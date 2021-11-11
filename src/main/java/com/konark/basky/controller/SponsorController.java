package com.konark.basky.controller;

import com.konark.basky.entity.Sponsor;
import com.konark.basky.entity.Sponsor;
import com.konark.basky.repo.SponsorRepo;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.SponsorService;
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
public class SponsorController {
    @Autowired
    private SponsorService sponsorService;
    @Autowired
    private SponsorRepo sponsorRepo;
    @Autowired
    private MessageService messageService;
    @GetMapping("/createSponsor")
    public String createSponsor(Model model, HttpSession session) {



        model.addAttribute("sponsor",new Sponsor());

        return "createSponsor";
    }

    @PostMapping("/createSponsor")
    public String createSponsor(@ModelAttribute Sponsor sponsor, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int sponsorId = sponsor.getSponsorId();
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(sponsor.getFirstName());
//        System.out.println(sponsor.getDob());
//        System.out.println(sponsor.getFirstName());

        sponsorService.createSponsor(sponsor);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created sponsor user.");
        return "redirect:/";
    }
    @GetMapping("/sponsors")
    public String SponsorController(Model model){
        model.addAttribute("sponsors", sponsorService.getAllSponsors());
        return "sponsors";
    }
    @GetMapping("/updateSponsor/{id}")
    public String updateSponsor(@PathVariable("id") int sponsorId, Model model, HttpSession Session){
        Sponsor sponsorDb= sponsorRepo.getSponsorById(sponsorId);
        System.out.println(sponsorDb.getSponsorId());
        model.addAttribute("sponsor", sponsorDb);
        model.addAttribute("id",  sponsorId);

        return "updateSponsor";
    }
    @PostMapping("/updateSponsor/{id}")
    public String updateSponsor(@PathVariable("id") int sponsorId,Sponsor sponsor, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        sponsor.setSponsorId(sponsorId);
        System.out.println(sponsor);
        try{
            sponsorService.updateSponsor(sponsorId,sponsor);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/sponsors";
        }catch (Exception e){}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("sponsor", sponsor);
        return "updateSponsor";
    }

}
