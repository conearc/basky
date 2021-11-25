package com.konark.basky.controller;

import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Block;
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
public class BlockController {
    @Autowired
    private BlockService blockService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/createBlock/{id}")
    public String createBlock(@PathVariable("id") int  matchId, Model model, HttpSession session) {

        if(!authenticationService.isAuthenticated(session))
        {
            return "redirect:/";
        }
        else
        {
            if(authenticationService.IsCoach(session))
            {
                return "redirect:/coach/home";
            }
        }

        List<Player> player=new ArrayList<>();
        model.addAttribute("player", player);
        model.addAttribute("id",matchId);
        model.addAttribute("block",new Block());
        List<Player> players= (List<Player>) playerService.getAllPlayers();
        model.addAttribute("players",players);

        return "createBlock";
    }

    @PostMapping("/createBlock/{id}")
    public String createBlock(@PathVariable("id") int matchId, @ModelAttribute Block block, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        block.setMatchId(matchId);
        System.out.println(matchId);
        int playerId = block.getPlayerId();
        Player player= (Player) playerService.getPlayerById(playerId);
        int teamId= player.getTeamId();
        Match match = (Match) matchService.getMatchById(matchId);

        matchService.updateMatch(match);
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(block.getFirstName());
//        System.out.println(block.getDob());
//        System.out.println(block.getFirstName());

        blockService.createBlock(block);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created block user.");
        return "redirect:/match/{id}";
    }
}
