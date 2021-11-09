package com.konark.basky.controller;


import com.konark.basky.entity.Coach;
import com.konark.basky.entity.Team;
import com.konark.basky.entity.User;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.TeamService;
import com.konark.basky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CoachController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;
    @Autowired
    private TeamService teamService;
    @GetMapping("/createCoach")
    public String loginCoach(Model model, HttpSession session) {
        List<Team> team=new ArrayList<>();
        model.addAttribute("team",team);
        List<Team> teams= (List<Team>) teamService.getAllTeams();
        model.addAttribute("user", new User());
        model.addAttribute("coach", new Coach());
        model.addAttribute("teams",teams);
        return "createCoach";
    }

    @PostMapping("/createCoach")
    public String postLoginCoach(@ModelAttribute User user, @ModelAttribute Coach coach, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        String username = user.getUsername();
        String password = user.getPassword();
        String errorMessage = null;

        System.out.println(username);
        System.out.println(coach);
        System.out.println(coach.getDob());
        System.out.println(coach.getFirstName());
        if (userService.checkIfUserExists(username)) {
            errorMessage= "This username already exists";
            messageService.displayErrorMessage(model, errorMessage);
            System.out.println(errorMessage);
            model.addAttribute("user", new User());
            model.addAttribute("coach", new Coach());
            return "createCoach";
        }

        userService.createCoach(username,password,coach);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created coach user.");
        return "redirect:/";
    }
}
