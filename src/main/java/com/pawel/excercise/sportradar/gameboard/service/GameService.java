package com.pawel.excercise.sportradar.gameboard.service;

import com.pawel.excercise.sportradar.gameboard.domain.Team;
import com.pawel.excercise.sportradar.gameboard.utils.GameObservable;
import com.pawel.excercise.sportradar.gameboard.utils.GameObserver;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GameService extends GameObservable {
    private final Pair<Team, Team> game;

    public GameService(final Pair<Team, Team> game, final GameObserver gameBoard) {
        this.game = game;
        this.observers.add(gameBoard);
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

        notifyObservers();
    }

    public void finishGame(Pair<Team, Team> game) {
        observers.forEach(
                o -> o.removeGameFromBoard(game));
    }

    public List<GameObserver> getGameObservers() {
        return observers;
    }
}
