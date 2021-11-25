package com.konark.basky.controller;

import com.konark.basky.entity.*;
import com.konark.basky.repo.MatchRepo;
import com.konark.basky.repo.UmpireRepo;
import com.konark.basky.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    @Autowired
    private MatchRepo matchRepo;
    @Autowired
    private UmpireService umpireService;
    @Autowired
    private SponsorService sponsorService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private CourtService courtService;
    @GetMapping("/matchs")
    public String MatchController(Model model){

//        List<Match> matchs= (List<Match>) matchService.getAllMatchs();
//        List<Match> currentMatchs= new ArrayList<>() ;
//        currentMatchs.add(matchs.get(0));
//        for(int i=0;i<matchs.size();i++){
////            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println(now);
//
//            if(matchs.get(i).getDate().compareTo(now)>=0 &&  Boolean.compare(matchs.get(i).isFinished(), false)==0){
//                currentMatchs.add(matchs.get(i));
//
//            }
//
//        }
        List<Match> matchs= (List<Match>) matchService.getRunningMatchs();
        model.addAttribute("matchs",matchs);
        List<Match> finishedMatchs= (List<Match>) matchService.getFinishedMatchs();
        model.addAttribute("finishedMatchs",finishedMatchs);
        List<Match> upcomingMatchs= (List<Match>) matchService.getUpcomingMatchs();
        model.addAttribute("upcomingMatchs",upcomingMatchs);


        return "matchs";
    }
    @GetMapping("/match/{id}")
    public String seeMatch(@PathVariable("id") int matchId, Model model, HttpSession session){
        Match match = (Match) matchService.getMatchById(matchId);
        model.addAttribute("match",match);
        model.addAttribute("id",matchId);
        return "oneMatch";




    }

    @GetMapping("/endMatch/{id}")
    public String endMatch(@PathVariable("id") int matchId, Model model, HttpSession session){
        Match match= matchRepo.getMatchById(matchId);
        match.setFinished(true);
        matchRepo.update(match);
        return "redirect:/matchs";
    }

    @GetMapping("/createMatch")
    public String createMatch(Model model, HttpSession session) {

        model.addAttribute("match", new Match());
        List<Team> team1s= (List<Team>) teamService.getAllTeams();
        model.addAttribute("team1s",team1s);
        List<Team> team2s= (List<Team>) teamService.getAllTeams();
        model.addAttribute("team2s",team2s);
        List<Umpire> umpires= (List<Umpire>) umpireService.getAllUmpires();
        model.addAttribute("umpires",umpires);
        List<Sponsor> sponsors= (List<Sponsor>) sponsorService.getAllSponsors();
        model.addAttribute("sponsors",sponsors);
        List<Org> orgs= (List<Org>) orgService.getAllOrgs();
        model.addAttribute("orgs",orgs);
        List<Court> courts= (List<Court>) courtService.getAllCourts();
        model.addAttribute("courts",courts);
        
        return "createMatch";
    }

    @PostMapping("/createMatch")
    public String createMatch(@ModelAttribute Match match, Model model, HttpSession session, RedirectAttributes redirectAttributes) {




        matchRepo.createMatch(match);


        return "redirect:/matchs";
    }

}
