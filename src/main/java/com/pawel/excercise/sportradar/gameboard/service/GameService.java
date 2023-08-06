package com.pawel.excercise.sportradar.gameboard.service;

import com.pawel.excercise.sportradar.gameboard.domain.GameBoard;
import com.pawel.excercise.sportradar.gameboard.domain.Team;
import org.springframework.data.util.Pair;

public class GameService {
    private Pair<Team, Team> game;
    private GameBoard gameBoard;

    public GameService(Pair<Team, Team> game, GameBoard gameBoard) {
        this.game = game;
        this.gameBoard = gameBoard;
    }

    public GameService() {
    }
}
