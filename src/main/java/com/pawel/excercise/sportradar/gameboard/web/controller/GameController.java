package com.pawel.excercise.sportradar.gameboard.web.controller;

import com.pawel.excercise.sportradar.gameboard.domain.Team;
import com.pawel.excercise.sportradar.gameboard.utils.NewScore;
import com.pawel.excercise.sportradar.gameboard.web.service.GameService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add-team")
    public Team addTeam(@RequestBody Team team)  {
        gameService.addTeam(team);
        return team;
    }

    @GetMapping("get-all-teams")
    public List<Team> getAllTeams() {
        return gameService.getTeams();
    }

    //games

    @GetMapping("/get-all-games")
    public List<Pair<Team, Team>> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping("/add-game")
    public void addNewGame() {
        Team team1 = gameService.getTeam(0);
        Team team2 = gameService.getTeam(1);

        gameService.addGame(team1, team2);
    }

    @GetMapping("/start-game")
    public void startGame() {
        gameService.startGame(0);
    }

    @PostMapping("/update-score")
    public void updateGameScore(@RequestBody NewScore newScore) {
        gameService.updateScore(0, newScore);
    }

}
