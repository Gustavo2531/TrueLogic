package com.truelogic.mvp_toolkit_api.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="Player")
public class Player {
    @Id
    @Column (name = "NAME")
    private String name;

    //private @NonNull String uuid;
    @Column(name="TYPE")
    private String type;
    public Player(){

    }
    public Player(String name, String type){
        this.name = name;
        this.type =  type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

