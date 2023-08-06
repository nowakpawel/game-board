package com.pawel.excercise.sportradar.gameboard.service;

import com.pawel.excercise.sportradar.gameboard.domain.GameBoard;
import com.pawel.excercise.sportradar.gameboard.domain.Team;
import org.springframework.data.util.Pair;

public class GameService {
    private final Pair<Team, Team> game;
    private final GameBoard gameBoard;

    public GameService(final Pair<Team, Team> game, final GameBoard gameBoard) {
        this.game = game;
        this.gameBoard = gameBoard;
    }
}
