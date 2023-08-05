package com.pawel.excercise.sportradar.gameboard.domain;

import org.junit.jupiter.api.Test;

public class TeamTest {

    @Test
    void shouldSetTeamName() {
        Team team = new Team();

        team.setName("poland");
        
    }
}
