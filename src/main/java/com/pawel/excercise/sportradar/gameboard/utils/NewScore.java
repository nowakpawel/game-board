package com.pawel.excercise.sportradar.gameboard.utils;

import org.springframework.stereotype.Component;

@Component
public class NewScore {
    private Integer score1;
    private Integer score2;

    public NewScore() {
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }
}
