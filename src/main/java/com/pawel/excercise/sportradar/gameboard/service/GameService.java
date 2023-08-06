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

    public Pair<Team, Team> getGame() {
        return game;
    }

    public void startGame() {
        this.game.getFirst().setScore(0);
        this.game.getSecond().setScore(0);
        //TODO: add currentGame to Board
    }

    public void updateScore(Pair<Integer, Integer> newScore) {
        this.game.getFirst().setScore(newScore.getFirst());
        this.game.getSecond().setScore(newScore.getSecond());

        notifyObserver();
    }

    public void notifyObserver() {
        gameBoard.update();
    }
}
