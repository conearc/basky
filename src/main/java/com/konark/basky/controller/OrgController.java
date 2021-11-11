package com.konark.basky.controller;

import com.konark.basky.entity.*;
import com.konark.basky.entity.Org;
import com.konark.basky.entity.Org;
import com.konark.basky.repo.OrgRepo;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.OrgService;
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
public class OrgController {
    @Autowired
    private OrgService orgService;
    @Autowired
    private OrgRepo orgRepo;
    @Autowired
    private MessageService messageService;
    @GetMapping("/createOrg")
    public String createOrg(Model model, HttpSession session) {



        model.addAttribute("org",new Org());

        return "createOrg";
    }

    @PostMapping("/createOrg")
    public String createOrg(@ModelAttribute Org org, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        int orgId = org.getOrgId();
        String errorMessage = null;
        System.out.println(org.getRole());
//        System.out.println(username);
//        System.out.println(org.getFirstName());
//        System.out.println(org.getDob());
//        System.out.println(org.getFirstName());

        orgService.createOrg(org);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created org user.");
        return "redirect:/";
    }
    @GetMapping("/orgs")
    public String OrgController(Model model){
        model.addAttribute("orgs", orgService.getAllOrgs());
        return "orgs";
    }
    @GetMapping("/updateOrg/{id}")
    public String updateOrg(@PathVariable("id") int orgId, Model model, HttpSession Session){
        Org orgDb= orgRepo.getOrgById(orgId);
        System.out.println(orgDb.getOrgId());
        model.addAttribute("org", orgDb);
        model.addAttribute("id",  orgId);



        return "updateOrg";
    }
    @PostMapping("/updateOrg/{id}")
    public String updateOrg(@PathVariable("id") int orgId,Org org, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        org.setOrgId(orgId);
        System.out.println(org);
        try{
            orgService.updateOrg(orgId,org);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/orgs";
        }catch (Exception e){System.out.println(e);}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("org", org);
        return "updateOrg";
    }

}
