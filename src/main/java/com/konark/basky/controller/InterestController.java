package com.konark.basky.controller;

import com.konark.basky.entity.Interest;
import com.konark.basky.entity.Interest;
import com.konark.basky.repo.InterestRepo;
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
public class InterestController {
    @Autowired
    private InterestRepo interestRepo;
    @GetMapping("/createInterest")
    public String create(Model model){
        model.addAttribute("interest",new Interest());
        return "createInterest";
    }
    @PostMapping("/createInterest")
    public String createInterest(@ModelAttribute Interest interest, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int interestId = interest.getInterestId();


//        System.out.println(username);
//        System.out.println(interest.getFirstName());
//        System.out.println(interest.getDob());
//        System.out.println(interest.getFirstName());


        interestRepo.createInterest(interest);

        return "redirect:/";
    }
    @GetMapping("/interests")
    public String InterestController(Model model){
        model.addAttribute("interests", interestRepo.getAllInterests());
        return "interests";
    }
    @GetMapping("/deleteInterest/{id}")
    public String interests(@PathVariable("id") int interestId, Model model, HttpSession session){
        interestRepo.deleteInterest(interestId);

        return "redirect:/interests";
    }

}
