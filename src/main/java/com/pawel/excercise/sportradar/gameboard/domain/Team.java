package com.pawel.excercise.sportradar.gameboard.domain;

public class Team {
    private String name;
    private Integer score;

    public Team() {
    }

    public Team(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
