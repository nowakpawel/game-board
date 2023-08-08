package com.pawel.excercise.sportradar.gameboard.web.repository;

import com.pawel.excercise.sportradar.gameboard.domain.Team;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepository {
    private List<Pair<Team, Team>> matches = new ArrayList<>();
    public GameRepository() {
    }

    public void addNewGame(Pair<Team, Team> newGame) {
        matches.add(newGame);
    }

    public List<Pair<Team, Team>> getAllGames() {
        return matches;
    }

    public void removeGame(Pair<Team, Team> match) {
        matches.remove(match);
    }

    public void addNewGame(Team team1, Team team2) {
        matches.add(0, Pair.of(team1, team2));
    }
}
