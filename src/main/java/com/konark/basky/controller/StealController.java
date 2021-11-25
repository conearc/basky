package com.konark.basky.controller;


import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Steal;
import com.konark.basky.service.MatchService;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.PlayerService;
import com.konark.basky.service.StealService;
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
public class StealController {
    @Autowired
    private StealService stealService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/createSteal/{id}")
    public String createSteal(@PathVariable("id") int  matchId, Model model, HttpSession session) {

        List<Player> player=new ArrayList<>();
        model.addAttribute("player", player);
        model.addAttribute("id",matchId);
        model.addAttribute("steal",new Steal());
        List<Player> players= (List<Player>) playerService.getAllPlayers();
        model.addAttribute("players",players);

        return "createSteal";
    }

    @PostMapping("/createSteal/{id}")
    public String createSteal(@PathVariable("id") int matchId, @ModelAttribute Steal steal, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        steal.setMatchId(matchId);
        System.out.println(matchId);
        int playerId = steal.getPlayerId();
        Player player= (Player) playerService.getPlayerById(playerId);
        int teamId= player.getTeamId();
        Match match = (Match) matchService.getMatchById(matchId);

        matchService.updateMatch(match);
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(steal.getFirstName());
//        System.out.println(steal.getDob());
//        System.out.println(steal.getFirstName());

        stealService.createSteal(steal);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created steal user.");
        return "redirect:/match/{id}";
    }
}
