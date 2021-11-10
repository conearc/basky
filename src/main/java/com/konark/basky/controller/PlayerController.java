package com.konark.basky.controller;

import com.konark.basky.entity.Player;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Team;
import com.konark.basky.repo.PlayerRepo;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.PlayerService;
import com.konark.basky.service.PlayerService;
import com.konark.basky.service.TeamService;
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
public class PlayerController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private TeamService teamService;

    @GetMapping("/createPlayer")
    public String createPlayer(Model model, HttpSession session) {

        List<Team> team=new ArrayList<>();
        model.addAttribute("team", team);

        model.addAttribute("player",new Player());
        List<Team> teams= (List<Team>) teamService.getAllTeams();
        model.addAttribute("teams",teams);
        return "createPlayer";
    }

    @PostMapping("/createPlayer")
    public String createPlayer(@ModelAttribute Player player, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int playerId = player.getPlayerId();
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(player.getFirstName());
//        System.out.println(player.getDob());
//        System.out.println(player.getFirstName());

        playerService.createPlayer(player);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created player user.");
        return "redirect:/";
    }
    @GetMapping("/players")
    public String PlayerController(Model model){
        model.addAttribute("players", playerService.getAllPlayers());
        return "players";
    }
    @GetMapping("/updatePlayer/{id}")
    public String updatePlayer(@PathVariable("id") int playerId, Model model, HttpSession Session){
        Player playerDb= playerRepo.getPlayerById(playerId);
        System.out.println(playerDb.getPlayerId());
        model.addAttribute("player", playerDb);
        model.addAttribute("id",  playerId);
        List<Team> team=new ArrayList<>();
        model.addAttribute("team",  team);

        List<Team> teams= (List<Team>) teamService.getAllTeams();
        model.addAttribute("teams",teams);
        return "updatePlayer";
    }
    @PostMapping("/updatePlayer/{id}")
    public String updatePlayer(@PathVariable("id") int playerId,Player player, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        player.setPlayerId(playerId);
        System.out.println(player);
        try{
            playerService.updatePlayer(playerId,player);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/players";
        }catch (Exception e){}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("player", player);
        return "updatePlayer";
    }
}
