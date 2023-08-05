package com.pawel.excercise.sportradar.gameboard.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {

    @Test
    void shouldSetTeamName() {
        Team team = new Team();

        team.setName("Poland");

        assertEquals("Poland", team.getName());
    }

    @Test
    void shouldBeAbleToSetScoreToTeam() {
        Team team = new Team();

        team.setScore(10);

        assertEquals(10, team.getScore());
    }
}
