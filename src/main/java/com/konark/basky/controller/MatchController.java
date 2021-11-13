package com.konark.basky.controller;

import com.konark.basky.entity.Match;
import com.konark.basky.service.MatchService;
import com.konark.basky.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private TeamService teamService;
    @GetMapping("/matchs")
    public String MatchController(Model model){

        List<Match> matchs= (List<Match>) matchService.getAllMatchs();
        List<Match> currentMatchs= new ArrayList<>() ;
        for(int i=0;i<matchs.size();i++){
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            if(matchs.get(i).getDate().compareTo(now)>=0 &&  Boolean.compare(matchs.get(i).isFinished(),false)==0){
                currentMatchs.add(matchs.get(i));

            }

        }
        model.addAttribute("matchs",matchs);
        return "matchs";
    }

}
