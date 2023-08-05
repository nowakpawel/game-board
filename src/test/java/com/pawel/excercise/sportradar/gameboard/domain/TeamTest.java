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
}
