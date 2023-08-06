package com.pawel.excercise.sportradar.gameboard.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameBoardTest {
    private GameBoard underTest;

    @BeforeEach
    void setUp() {
        underTest = new GameBoard();
    }

    @Test
    void shouldBeAbleToGetAllGames() {
        assertNotNull(underTest.getAllGames);
    }
}