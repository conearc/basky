package com.konark.basky.service;

import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Team;
import com.konark.basky.repo.MatchRepo;
import com.konark.basky.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    @Autowired
    private TeamRepo teamRepo;

    public Object getMatchById(int id){return matchRepo.getMatchById(id);};
    public Object getAllMatchs() {
        return matchRepo.getAllMatchs();
    }
    public void updateMatch( Match match) {
        matchRepo.update(match);
    }
    public Object getRunningMatchs() {

        List<Match> ms = matchRepo.getRunningMatchs();

        for(int i=0;i<ms.size();i++)
        {
            Team team1 = teamRepo.getTeam(ms.get(i).getTeam1Id());
            ms.get(i).setTeam1(team1);
            System.out.println(team1.toString());
            Team team2 = teamRepo.getTeam(ms.get(i).getTeam2Id());
            ms.get(i).setTeam2(team2);
        }

        return ms;
    }
    public Object getFinishedMatchs() {

        List<Match> ms = matchRepo.getFinishedMatchs();

        for(int i=0;i<ms.size();i++)
        {
            Team team1 = teamRepo.getTeam(ms.get(i).getTeam1Id());
            ms.get(i).setTeam1(team1);
            System.out.println(team1.toString());
            Team team2 = teamRepo.getTeam(ms.get(i).getTeam2Id());
            ms.get(i).setTeam2(team2);
        }

        return ms;
    }
    public Object getUpcomingMatchs() {

        List<Match> ms = matchRepo.getUpcomingMatchs();

        for(int i=0;i<ms.size();i++)
        {
            Team team1 = teamRepo.getTeam(ms.get(i).getTeam1Id());
            ms.get(i).setTeam1(team1);
            System.out.println(team1.toString());
            Team team2 = teamRepo.getTeam(ms.get(i).getTeam2Id());
            ms.get(i).setTeam2(team2);
        }

        return ms;
    }
}
