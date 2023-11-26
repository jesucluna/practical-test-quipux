package com.quipux.practical_test.model;

import java.util.List;

public class Team {
    private String name;
    private String stadium;
    private int numberOfTitles;
    private List<Player> startingPlayers;
    private List<Player> substitutePlayers;

    public Team() {}

    public Team(String name, String stadium, int numberOfTitles, List<Player> startingPlayers, List<Player> substitutePlayers) {
        this.name = name;
        this.stadium = stadium;
        this.numberOfTitles = numberOfTitles;
        this.startingPlayers = startingPlayers;
        this.substitutePlayers = substitutePlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getNumberOfTitles() {
        return numberOfTitles;
    }

    public void setNumberOfTitles(int numberOfTitles) {
        this.numberOfTitles = numberOfTitles;
    }

    public List<Player> getStartingPlayers() {
        return startingPlayers;
    }

    public void setStartingPlayers(List<Player> startingPlayers) {
        this.startingPlayers = startingPlayers;
    }

    public List<Player> getSubstitutePlayers() {
        return substitutePlayers;
    }

    public void setSubstitutePlayers(List<Player> substitutePlayers) {
        this.substitutePlayers = substitutePlayers;
    }
}
