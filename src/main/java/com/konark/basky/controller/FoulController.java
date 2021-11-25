package com.konark.basky.controller;

import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Foul;
import com.konark.basky.entity.Umpire;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class FoulController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UmpireService umpireService;
    @Autowired
    private FoulService foulService;

    @GetMapping("/createFoul/{id}")
    public String createFoul(@PathVariable("id") int  matchId, Model model, HttpSession session) {

        List<Player> player=new ArrayList<>();
        model.addAttribute("player", player);
        model.addAttribute("id",matchId);
        model.addAttribute("foul",new Foul());
        List<Player> players= (List<Player>) playerService.getAllPlayers();
        model.addAttribute("players",players);
        List<Umpire> umpire=new ArrayList<>();
        model.addAttribute("umpire", umpire);
        List<Umpire> umpires= (List<Umpire>) umpireService.getAllUmpires();
        model.addAttribute("umpires", umpires);


        return "createFoul";
    }

    @PostMapping("/createFoul/{id}")
    public String createFoul(@PathVariable("id") int matchId, @ModelAttribute Foul foul, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        foul.setMatchId(matchId);
        System.out.println(matchId);
        int playerId = foul.getPlayerId();
        Player player= (Player) playerService.getPlayerById(playerId);
        int teamId= player.getTeamId();
        Match match = (Match) matchService.getMatchById(matchId);

        matchService.updateMatch(match);
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(foul.getFirstName());
//        System.out.println(foul.getDob());
//        System.out.println(foul.getFirstName());

        foulService.createFoul(foul);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created foul user.");
        return "redirect:/match/{id}";
    }
}
