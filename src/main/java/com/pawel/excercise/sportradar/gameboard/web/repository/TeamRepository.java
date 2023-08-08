package com.pawel.excercise.sportradar.gameboard.web.repository;

import com.pawel.excercise.sportradar.gameboard.domain.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamRepository {

    public TeamRepository() {
    }

    private List<Team> allTeams = new ArrayList<>();

    public void addNewTeam(Team newTeam) {
        allTeams.add(newTeam);
    }

    public List<Team> getAllTeams() {
        return allTeams;
    }

    public Team getTeam(Integer index) {
        return allTeams.get(index);
    }
}
