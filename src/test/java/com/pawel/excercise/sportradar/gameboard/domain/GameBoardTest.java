package com.pawel.excercise.sportradar.gameboard.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameBoardTest {
    private GameBoard underTest;

    @BeforeEach
    void setUp() {
        underTest = new GameBoard();
    }

    @Test
    void shouldBeAbleToGetAllGames() {
        assertNotNull(underTest.getAllGames());
    }

    @Test
    void shouldBeAbleToAddGameToBoard() {
        Team polishTeam = new Team();
        Team germanTeam = new Team();
        Pair<Team, Team> newGame = Pair.of(polishTeam, germanTeam);

        underTest.addGameToBard(newGame);
        
        assertEquals(1, underTest.getAllGames().size());
    }

    @Test
    void shouldBeAbleToRemoveGameFrpomTheBoard() {
        Team polishTeam = new Team();
        Team germanTeam = new Team();
        Pair<Team, Team> newGame = Pair.of(polishTeam, germanTeam);

        underTest.addGameToBard(newGame);

        underTest.removeGame(newGame);

        assertEquals(underTest.getAllGames().size(), 0);
    }
}