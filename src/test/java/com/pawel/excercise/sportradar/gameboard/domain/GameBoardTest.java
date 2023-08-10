package com.pawel.excercise.sportradar.gameboard.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldBeAbleToRemoveGameFromTheBoard() {
        Team polishTeam = new Team();
        Team germanTeam = new Team();
        Pair<Team, Team> newGame = Pair.of(polishTeam, germanTeam);

        underTest.addGameToBard(newGame);

        underTest.removeGameFromBoard(newGame);

        assertEquals(underTest.getAllGames().size(), 0);
    }

    @Test
    void shouldSortAllMatchesResults() {
        Team team1 = new Team("Test Team 1", 1);
        Team team2 = new Team("Test Team 2", 2);
        Team team3 = new Team("Test Team 3", 3);
        Team team4 = new Team("Test Team 4", 0);
        Team team5 = new Team("Test Team 5", 5);
        Team team6 = new Team("Test Team 6", 7);
        Team team7 = new Team("Test Team 7", 0);
        Team team8 = new Team("Test Team 8", 1);

        List<Pair<Team, Team>> games = List.of(
                Pair.of(team1, team2), //sum of score = 3
                Pair.of(team3, team4), //sum of score = 3
                Pair.of(team4, team7), //sum of score = 0
                Pair.of(team5, team6), //sum of score = 12
                Pair.of(team7, team8), //sum of score = 1
                Pair.of(team3, team5) //sum of score = 8
        );

        List<Pair<Team, Team>> orderedGames = List.of(
                Pair.of(team5, team6),
                Pair.of(team3, team5),
                Pair.of(team3, team4),
                Pair.of(team1, team2),
                Pair.of(team7, team8),
                Pair.of(team4, team7)
        );

        games.stream()
                .forEach(game -> underTest.addGameToBard(game));

        underTest.update();

        assertEquals(games, orderedGames);

    }
}