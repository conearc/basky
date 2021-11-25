package com.konark.basky.controller;

import com.konark.basky.entity.Rebound;
import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.service.ReboundService;
import com.konark.basky.service.MatchService;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.PlayerService;
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
public class ReboundController {
    @Autowired
    private ReboundService reboundService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/createRebound/{id}")
    public String createRebound(@PathVariable("id") int  matchId, Model model, HttpSession session) {

        List<Player> player=new ArrayList<>();
        model.addAttribute("player", player);
        model.addAttribute("id",matchId);
        model.addAttribute("rebound",new Rebound());
        List<Player> players= (List<Player>) playerService.getAllPlayers();
        model.addAttribute("players",players);

        return "createRebound";
    }

    @PostMapping("/createRebound/{id}")
    public String createRebound(@PathVariable("id") int matchId, @ModelAttribute Rebound rebound, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        rebound.setMatchId(matchId);
        System.out.println(matchId);
        int playerId = rebound.getPlayerId();
        Player player= (Player) playerService.getPlayerById(playerId);
        int teamId= player.getTeamId();
        Match match = (Match) matchService.getMatchById(matchId);

        matchService.updateMatch(match);
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(rebound.getFirstName());
//        System.out.println(rebound.getDob());
//        System.out.println(rebound.getFirstName());

        reboundService.createRebound(rebound);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created rebound user.");
        return "redirect:/match/{id}";
    }
}
