package com.konark.basky.service;


import com.konark.basky.entity.Team;

import com.konark.basky.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;
    public void createTeam(Team team)
    {
        teamRepo.createTeam(team);
    }
    public Boolean checkIfTeamExists(String teamName) {
        return teamRepo.checkIfTeamExists(teamName);
    }

    public Object getAllTeams() {
        return teamRepo.getAllTeams();
    }

    public void updateTeam(int teamId, Team team) {
        Team teamDB = teamRepo.getTeam(teamId);
        System.out.println(team.getTeamName());
        if(Objects.nonNull(team.getTeamName()) &&
                !"".equalsIgnoreCase(team.getTeamName())) {
            System.out.println("hi");

            teamDB.setTeamName(team.getTeamName());
        }
        if(Objects.nonNull(team.getPhoneNo()) &&
                !"".equalsIgnoreCase(team.getPhoneNo())) {
            teamDB.setPhoneNo(team.getPhoneNo());
        }
        if(Objects.nonNull(team.getState()) &&
                !"".equalsIgnoreCase(team.getState())) {
            teamDB.setState(team.getState());
        }
        if(Objects.nonNull(team.getCity()) &&
                !"".equalsIgnoreCase(team.getCity())) {
            teamDB.setCity(team.getCity());
        }
        if(Objects.nonNull(team.getPin()) ){
            teamDB.setPin(team.getPin());
        }
        System.out.println(teamDB);
         teamRepo.update(teamDB);
    }

}
