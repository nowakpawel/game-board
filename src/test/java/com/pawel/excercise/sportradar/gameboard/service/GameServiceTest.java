package com.pawel.excercise.sportradar.gameboard.service;

import com.pawel.excercise.sportradar.gameboard.domain.GameBoard;
import com.pawel.excercise.sportradar.gameboard.domain.Team;
import com.pawel.excercise.sportradar.gameboard.utils.GameObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.util.Pair;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameServiceTest {
    private GameService underTest;
    private GameObserver gameBoard = mock(GameBoard.class);
    private Pair<Team, Team> game;
    @BeforeEach
    void setUp() {
        Team polishTeam = new Team();
        Team germanTeam = new Team();
        game = Pair.of(polishTeam, germanTeam);

        underTest = new GameService(game, gameBoard);
    }

    @Test
    void shouldBeAbleToCreateGameServiceWithDependencies() {
        assertThat(underTest).isNotNull();
    }

    @Test
    void shouldReturnGameTeams() {
        Pair<Team, Team> currentGame = underTest.getGame();

       assertThat(currentGame.getFirst()).isInstanceOf(Team.class);
       assertThat(currentGame.getSecond()).isInstanceOf(Team.class);
    }

    @Test
    void shouldBeAbleToInitialGame() {
        underTest.startGame();

        Pair<Team, Team> currentGame = underTest.getGame();

        assertEquals(currentGame.getFirst().getScore(), 0);
        assertEquals(currentGame.getSecond().getScore(), 0);
    }

    @Test
    void shouldBeAbleToUpdateMatchScore() {
        underTest.getGame();

        Pair<Integer, Integer> newScore = Pair.of(4, 1);

        underTest.updateScore(newScore);

        assertEquals(underTest.getGame().getFirst().getScore(), 4);
        assertEquals(underTest.getGame().getSecond().getScore(), 1);

        verify(gameBoard, times(1)).update();
    }

    @Test
    void shouldBeAbleToAddNewObserver() {
        GameObserver newObserver = new GameBoard();
        underTest.addNewGameObserver(newObserver);

        assertEquals(underTest.getGameObservers().size(), 2);
    }

    @Test
    void shouldBeAbleToRemoveObserver() {
        underTest.removeGameObserver(gameBoard);

        assertEquals(underTest.observers.size(), 0);
    }

    @Test
    void shouldNotifyObserversWhenScoreUpdated() {
        underTest.updateScore(Pair.of(4, 0));

        verify(gameBoard, times(1)).update();
    }

    @Test
    void shouldBeAbleToFinishGame() {

        underTest.finishGame(game);
        verify(gameBoard, times(1)).removeGameFromBoard(any());
    }
}
