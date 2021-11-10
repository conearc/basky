package com.konark.basky.controller;

import com.konark.basky.entity.Umpire;
import com.konark.basky.entity.Umpire;
import com.konark.basky.entity.Team;
import com.konark.basky.repo.UmpireRepo;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.UmpireService;
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
public class UmpireController {
    @Autowired
    private UmpireService umpireService;
    @Autowired
    private UmpireRepo umpireRepo;
    @Autowired
    private MessageService messageService;
    @GetMapping("/createUmpire")
    public String createUmpire(Model model, HttpSession session) {



        model.addAttribute("umpire",new Umpire());

        return "createUmpire";
    }

    @PostMapping("/createUmpire")
    public String createUmpire(@ModelAttribute Umpire umpire, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int umpireId = umpire.getUmpireId();
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(umpire.getFirstName());
//        System.out.println(umpire.getDob());
//        System.out.println(umpire.getFirstName());

        umpireService.createUmpire(umpire);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created umpire user.");
        return "redirect:/";
    }

    @GetMapping("/umpires")
    public String UmpireController(Model model){
        model.addAttribute("umpires", umpireService.getAllUmpires());
        return "umpires";
    }
    @GetMapping("/updateUmpire/{id}")
    public String updateUmpire(@PathVariable("id") int umpireId, Model model, HttpSession Session){
        Umpire umpireDb= umpireRepo.getUmpireById(umpireId);
        System.out.println(umpireDb.getUmpireId());
        model.addAttribute("umpire", umpireDb);
        model.addAttribute("id",  umpireId);

        return "updateUmpire";
    }
    @PostMapping("/updateUmpire/{id}")
    public String updateUmpire(@PathVariable("id") int umpireId,Umpire umpire, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        umpire.setUmpireId(umpireId);
        System.out.println(umpire);
        try{
            umpireService.updateUmpire(umpireId,umpire);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/umpires";
        }catch (Exception e){}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("umpire", umpire);
        return "updateUmpire";
    }
}
