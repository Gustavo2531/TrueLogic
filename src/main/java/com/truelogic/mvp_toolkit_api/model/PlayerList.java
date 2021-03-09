package com.truelogic.mvp_toolkit_api.model;

import java.io.Serializable;
import java.util.List;

public class PlayerList implements Serializable {
    private List<Player> players;

    public PlayerList() {}

    public List<Player> getPlayers() {
        return players;
    }
}
