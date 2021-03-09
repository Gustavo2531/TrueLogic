package com.truelogic.mvp_toolkit_api.repository;
import com.truelogic.mvp_toolkit_api.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, String> {

    public Optional<Player> findByName(String name);

}