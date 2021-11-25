package com.konark.basky.controller;


import com.konark.basky.entity.Coach;
import com.konark.basky.entity.Interest;
import com.konark.basky.entity.Team;
import com.konark.basky.entity.User;
import com.konark.basky.repo.InterestRepo;
import com.konark.basky.service.CoachService;
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

    @Autowired
    private CoachService coachService;

    @Autowired
    private InterestRepo interestRepo;

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
    public String postLoginCoach( @ModelAttribute Coach coach, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        coachService.createCoach(coach);

        return "redirect:/";
    }
    @GetMapping("/createCoach/{id}")
    public String createCoachInterest(@PathVariable("id") int interestId, Model model, HttpSession session) {
        Interest interest= interestRepo.getInterest(interestId);
        Coach coach =new Coach();
        coach.setFirstName(interest.getFirstName());
        coach.setLastName(interest.getLastName());
        coach.setPhoneNo(interest.getPhoneNo());
        coach.setEmail(interest.getEmail());
        List<Team> team=new ArrayList<>();
        model.addAttribute("team",team);
        List<Team> teams= (List<Team>) teamService.getAllTeams();
        model.addAttribute("user", new User());

        model.addAttribute("teams",teams);



        model.addAttribute("coach", coach);
        return "createCoach";
    }
    @PostMapping("/createCoach/{id}")
    public String createCoachInterest(@PathVariable("id") int interestId, @ModelAttribute Coach coach, Model model, HttpSession session, RedirectAttributes redirectAttributes) {




        coachService.createCoach(coach);


        return "redirect:/interests";
    }
}
