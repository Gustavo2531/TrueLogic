package com.truelogic.mvp_toolkit_api.controller;

import com.truelogic.mvp_toolkit_api.model.Player;
import com.truelogic.mvp_toolkit_api.model.PlayerList;
import com.truelogic.mvp_toolkit_api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private KafkaTemplate<String, Player> kafkaTemplate;

    private static String TOPIC = "novice-players";

    @GetMapping("/players")
    public List<Player> getDevApps() {
        Iterable<Player> result = playerRepository.findAll();
        List<Player> playerList = new ArrayList<Player>();
        result.forEach(playerList::add);
        return playerList;
    }

    @PostMapping("/playerList")
    public String filterList(@RequestBody PlayerList newPlayers) {

        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String,Integer>();
        for (Player player : newPlayers.getPlayers()) {
            if(player.getType().toLowerCase().equals("expert")){
                if(!playerRepository.findByName(player.getName()).isPresent()){
                    Player newPlayer = new Player(player.getName(),player.getType());
                    playerRepository.save(newPlayer);
                }else{
                    Optional<Player> optionalPlayer = playerRepository.findByName(player.getName());
                    Player newPlayer = optionalPlayer.get();
                    newPlayer.setType(player.getType());
                    playerRepository.save(newPlayer);
                }
                hm.put(player.getName(),0);
            }else if (player.getType().toLowerCase().equals("novice")){
                //kafka topic
                kafkaTemplate.send(TOPIC, player);
                hm.put(player.getName(),1);
            }else{
                hm.put(player.getName(),2);
            }

        }
        String s =  "";
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            s+="player "+entry.getKey()+" ";
            switch(entry.getValue()){
                case 0:
                    s+="stored in db\n";
                    break;
                case 1:
                    s+="sent to kafka topic\n";
                    break;
                case 2:
                    s+= "did not fit\n";
                    break;

            }
        }
        return s;
    }
}


