package com.konark.basky.controller;

import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Assist;
import com.konark.basky.service.MatchService;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.PlayerService;
import com.konark.basky.service.AssistService;
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
public class AssistController {
    @Autowired
    private AssistService assistService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/createAssist/{id}")
    public String createAssist(@PathVariable("id") int  matchId, Model model, HttpSession session) {

        List<Player> player=new ArrayList<>();
        model.addAttribute("player", player);
        model.addAttribute("id",matchId);
        model.addAttribute("assist",new Assist());
        List<Player> players= (List<Player>) playerService.getAllPlayers();
        model.addAttribute("players",players);

        return "createAssist";
    }

    @PostMapping("/createAssist/{id}")
    public String createAssist(@PathVariable("id") int matchId, @ModelAttribute Assist assist, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        assist.setMatchId(matchId);
        System.out.println(matchId);
        int playerId = assist.getPlayerId();
        Player player= (Player) playerService.getPlayerById(playerId);
        int teamId= player.getTeamId();
        Match match = (Match) matchService.getMatchById(matchId);

        matchService.updateMatch(match);
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(assist.getFirstName());
//        System.out.println(assist.getDob());
//        System.out.println(assist.getFirstName());

        assistService.createAssist(assist);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created assist user.");
        return "redirect:/match/{id}";
    }
}
