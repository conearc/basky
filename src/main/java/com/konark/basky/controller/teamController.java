package com.konark.basky.controller;

import com.konark.basky.entity.Team;
import com.konark.basky.entity.User;
import com.konark.basky.repo.TeamRepo;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.TeamService;
import com.konark.basky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class teamController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepo teamRepo;
    @GetMapping("/createTeam")
    public String createTeam(Model model, HttpSession session) {

        model.addAttribute("team", new Team());
        return "createTeam";
    }

    @PostMapping("/createTeam")
    public String createTeam( @ModelAttribute Team team, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int teamId = team.getTeamId();
        String teamName= team.getTeamName();
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(team.getFirstName());
//        System.out.println(team.getDob());
//        System.out.println(team.getFirstName());
        if (teamService.checkIfTeamExists(teamName)){
            errorMessage= "This teamname already exists";
            messageService.displayErrorMessage(model, errorMessage);
            System.out.println(errorMessage);

            model.addAttribute("team", new Team());
            return "createTeam";
        }

        teamService.createTeam(team);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created team user.");
        return "redirect:/";
    }
    @GetMapping("/teams")
    public String TeamController(Model model){
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }

    @GetMapping("/updateTeam/{id}")
    public String updateTeam(@PathVariable("id") int teamId, Model model, HttpSession Session){
        Team teamDb= teamRepo.getTeam(teamId);
        System.out.println(teamDb.getTeamId());
        model.addAttribute("team", teamDb);
        model.addAttribute("id",  teamId);
        return "updateTeam";
    }
    @PostMapping("/updateTeam/{id}")
    public String updateTeam(@PathVariable("id") int teamId,Team team, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        team.setTeamId(teamId);
        System.out.println(team);
        try{
            teamService.updateTeam(teamId,team);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/teams";
        }catch (Exception e){}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("team", team);
        return "updateTeam";
    }

}
