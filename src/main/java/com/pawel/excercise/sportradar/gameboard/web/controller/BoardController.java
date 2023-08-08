package com.pawel.excercise.sportradar.gameboard.web.controller;

import com.pawel.excercise.sportradar.gameboard.domain.GameBoard;
import com.pawel.excercise.sportradar.gameboard.domain.Team;
import com.pawel.excercise.sportradar.gameboard.web.service.GameService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final GameService gameService;
    private final GameBoard gameBoard;

    public BoardController(GameService gameService, GameBoard gameBoard) {
        this.gameService = gameService;
        this.gameBoard = gameBoard;
    }

    @GetMapping("/")
    public List<Pair<Team, Team>> getAllGames() {
        return gameBoard.getAllGames();
    }


}
