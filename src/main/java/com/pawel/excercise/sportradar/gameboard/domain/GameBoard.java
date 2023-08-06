package com.pawel.excercise.sportradar.gameboard.domain;

import com.pawel.excercise.sportradar.gameboard.utils.GameObserver;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements GameObserver {

    private List<Pair<Team, Team>> allGames = new ArrayList<>();

    public List<Pair<Team, Team>> getAllGames() {
        return allGames;
    }

    public GameBoard() {
    }

    @Override
    public void update() {
        //some implementation
    }

    @Override
    public void addGameToBard(Pair<Team, Team> game) {
        allGames.add(game);
    }
}
