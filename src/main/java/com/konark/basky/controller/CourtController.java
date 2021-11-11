package com.konark.basky.controller;

import com.konark.basky.entity.Court;
import com.konark.basky.entity.Team;
import com.konark.basky.entity.Court;
import com.konark.basky.repo.CourtRepo;
import com.konark.basky.service.CourtService;
import com.konark.basky.service.MessageService;
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
public class CourtController {
    @Autowired
    private CourtService courtService;
    @Autowired
    private CourtRepo courtRepo;
    @Autowired
    private MessageService messageService;

    @GetMapping("/createCourt")
    public String createCourt(Model model, HttpSession session) {



        model.addAttribute("court",new Court());

        return "createCourt";
    }

    @PostMapping("/createCourt")
    public String createCourt(@ModelAttribute Court court, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int courtId = court.getCourtId();
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(court.getFirstName());
//        System.out.println(court.getDob());
//        System.out.println(court.getFirstName());

        courtService.createCourt(court);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created court user.");
        return "redirect:/";
    }

    @GetMapping("/courts")
    public String CourtController(Model model){
        model.addAttribute("courts", courtService.getAllCourts());
        return "courts";
    }
    @GetMapping("/updateCourt/{id}")
    public String updateCourt(@PathVariable("id") int courtId, Model model, HttpSession Session){
        Court courtDb= courtRepo.getCourtById(courtId);
        System.out.println(courtDb.getCourtId());
        model.addAttribute("court", courtDb);
        model.addAttribute("id",  courtId);

        return "updateCourt";
    }
    @PostMapping("/updateCourt/{id}")
    public String updateCourt(@PathVariable("id") int courtId,Court court, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        court.setCourtId(courtId);
        System.out.println(court);
        try{
            courtService.updateCourt(courtId,court);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/courts";
        }catch (Exception e){}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("court", court);
        return "updateCourt";
    }

}
