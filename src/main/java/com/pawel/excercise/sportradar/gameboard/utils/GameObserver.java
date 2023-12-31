package com.pawel.excercise.sportradar.gameboard.utils;

import com.pawel.excercise.sportradar.gameboard.domain.Team;
import org.springframework.data.util.Pair;

public interface GameObserver {
    void update();

    void addGameToBard(Pair<Team, Team> game);
    void removeGameFromBoard(Pair<Team, Team> game);
}
