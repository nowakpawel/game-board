package com.pawel.excercise.sportradar.gameboard.domain;

import com.pawel.excercise.sportradar.gameboard.utils.GameObserver;
import com.pawel.excercise.sportradar.gameboard.web.repository.GameRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameBoard implements GameObserver {
    private final GameRepository gameRepository;


    public GameBoard(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Pair<Team, Team>> getAllGames() {
        return gameRepository.getAllGames();
    }

    @Override
    public void update() {
       gameRepository.getAllGames().stream()
//               .map(game -> System.out::println(game));
    }

    @Override
    public void addGameToBard(Pair<Team, Team> game) {
        gameRepository.addNewGame(game);
    }

    @Override
    public void removeGameFromBoard(Pair<Team, Team> game) {
        gameRepository.removeGame(game);
    }
}
