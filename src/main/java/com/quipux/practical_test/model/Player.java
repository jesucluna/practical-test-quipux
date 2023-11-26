package com.quipux.practical_test.model;

import lombok.Getter;

@Getter
public class Player {
    private String name;
    private String position;
    public Player() {}

    public Player(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
