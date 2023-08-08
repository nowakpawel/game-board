package com.pawel.excercise.sportradar.gameboard.web.service;

import com.pawel.excercise.sportradar.gameboard.domain.GameBoard;
import com.pawel.excercise.sportradar.gameboard.domain.Team;
import com.pawel.excercise.sportradar.gameboard.utils.GameObservable;
import com.pawel.excercise.sportradar.gameboard.utils.GameObserver;
import com.pawel.excercise.sportradar.gameboard.utils.NewScore;
import com.pawel.excercise.sportradar.gameboard.web.repository.GameRepository;
import com.pawel.excercise.sportradar.gameboard.web.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService extends GameObservable {
    private final TeamRepository teamRepository; //should have separate service
    private final GameRepository gameRepository;
    private GameBoard gameBoard;

    @Autowired
    public GameService(final TeamRepository teamRepository, final GameBoard gameBoard, GameRepository gameRepository) {
        this.teamRepository = teamRepository;
        this.observers.add(gameBoard);
        this.gameRepository = gameRepository;
    }

    public Pair<Team, Team> getGame(int index) {
        return gameBoard.getAllGames().get(index);
    }

    public void startGame(int index) {
        Pair<Team, Team> game = this.gameRepository.getAllGames().get(index);

        game.getFirst().setScore(0);
        game.getSecond().setScore(0);
        observers.forEach(o -> o.addGameToBard(game));
    }

    public void updateScore(int gameIndex, NewScore newScore) {
        Pair<Team, Team> currentGame = this.gameRepository.getAllGames().get(gameIndex);
        currentGame.getFirst().setScore(newScore.getScore1());
        currentGame.getSecond().setScore(newScore.getScore2());

        notifyObservers();
    }

    public void finishGame(Pair<Team, Team> game) {
        observers.forEach(
                o -> o.removeGameFromBoard(game));
    }

    public List<GameObserver> getGameObservers() {
        return observers;
    }

    //Teams
    public void addTeam(Team team) {
        teamRepository.addNewTeam(team);
    }

    public List<Team> getTeams() {
        return teamRepository.getAllTeams();
    }

    public Team getTeam(Integer index) {
        return teamRepository.getTeam(index);
    }

    public void addGame(Team team1, Team team2) {
        gameRepository.addNewGame(team1, team2);
    }

    public List<Pair<Team, Team>> getAllGames() {
        return gameRepository.getAllGames();
    }
}
