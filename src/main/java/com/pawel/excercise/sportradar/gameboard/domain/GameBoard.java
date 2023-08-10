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
        List<Pair<Team, Team>> sortedGames = sort(allGames);

        sortedGames.stream()
                .forEach(game -> {
                    System.out.println(game.getFirst().getName() + ": " + game.getFirst().getScore() +
                            "\n" + game.getSecond().getName() + ": " + game.getSecond().getScore() + "\n====\n");
                });
    }

    @Override
    public void addGameToBard(Pair<Team, Team> game) {
        allGames.add(game);
    }

    @Override
    public void removeGameFromBoard(Pair<Team, Team> game) {
        allGames.remove(game);
    }

    private List<Pair<Team, Team>> sort(List<Pair<Team, Team>> games) {
        int allGamesSize = games.size();

        Pair<Team, Team> tempGame;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < allGamesSize - 1; i++) {
                if (getTotalGameScore(games.get(i)).compareTo(getTotalGameScore(games.get(i + 1))) > 0) {
                    tempGame = games.get(i);
                    games.set(i, games.get(i));
                    games.set((i + 1), tempGame);
                    sorted = false;
                }
            }
        }

        return games;
    }

    private Integer getTotalGameScore(Pair<Team, Team> game) {
        return game.getFirst().getScore() + game.getSecond().getScore();
    }
}
