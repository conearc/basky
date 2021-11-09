package com.konark.basky.controller;

import com.konark.basky.entity.Team;
import com.konark.basky.repo.TeamRepo;
import com.konark.basky.service.AuthenticationService;
import com.konark.basky.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MessageService messageService;
    @Autowired
    private TeamRepo teamRepo;
    @GetMapping("/")
    public String home(Model model, HttpSession session){
        List<Team> teams= teamRepo.getAllTeams();
        Collections.sort(teams,(Team team1, Team team2)->{
            if(team1.getNumberOfWins()==team2.getNumberOfWins()){
                 int diff1=team1.getPointsScored()-team1.getPointsAgainst();
                 int diff2= team2.getPointsScored()-team2.getPointsAgainst();
                 return (diff2-diff1);
            }
              else
                  return team2.getNumberOfWins()-team1.getNumberOfWins();

        });

        model.addAttribute("teams",teams);


        return "homePage";
    }
}
