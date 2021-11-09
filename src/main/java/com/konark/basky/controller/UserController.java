package com.konark.basky.controller;

import com.konark.basky.entity.Coach;
import com.konark.basky.entity.User;
import com.konark.basky.service.AuthenticationService;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;
    @GetMapping("/createAdmin")
    public String loginAdmin(Model model, HttpSession session) {
        model.addAttribute("admin", new User());
        return "createAdmin";
    }

    @PostMapping("/createAdmin")
    public String postLoginAdmin(@ModelAttribute User admin, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        String username = admin.getUsername();
        String password = admin.getPassword();
        String errorMessage = null;

        System.out.println(username);


        if (userService.checkIfUserExists(username)) {
            errorMessage= "This username already exists";
            messageService.displayErrorMessage(model, errorMessage);
            System.out.println(errorMessage);
            model.addAttribute("admin", new User());
            return "createAdmin";
        }

        userService.createAdmin(username,password);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created admin user.");
        return "redirect:/";
    }


}
