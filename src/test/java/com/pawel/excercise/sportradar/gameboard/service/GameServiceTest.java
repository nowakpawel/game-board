package com.pawel.excercise.sportradar.gameboard.service;

import com.pawel.excercise.sportradar.gameboard.domain.GameBoard;
import com.pawel.excercise.sportradar.gameboard.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {

    @Test
    void shouldBeAbleToCreateGameServiceWithDependencies() {
        Team polishTeam = new Team();
        Team germanTeam = new Team();
        Pair<Team, Team> game = Pair.of(polishTeam, germanTeam);

        GameBoard gameBoard = new GameBoard();

        GameService gameService = new GameService(game, gameBoard);
    }

    @Test
    void shouldReturnGameTeams() {
        Team polishTeam = new Team();
        Team germanTeam = new Team();
        Pair<Team, Team> game = Pair.of(polishTeam, germanTeam);

        GameBoard gameBoard = new GameBoard();

        GameService gameService = new GameService(game, gameBoard);
        Pair<Team, Team> currentGame = gameService.getGame();

        assertEquals(currentGame.getFirst(), polishTeam);
        assertEquals(currentGame.getSecond(), germanTeam);
    }



}
