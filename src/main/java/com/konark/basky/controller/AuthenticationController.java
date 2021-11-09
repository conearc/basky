package com.konark.basky.controller;

import com.konark.basky.entity.User;
import com.konark.basky.service.AuthenticationService;
import com.konark.basky.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MessageService messageService;

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        if (authenticationService.isAuthenticated(session)) {
            return "redirect:/";
        }

        model.addAttribute("loginData", new User());
        return "login";
    }


    @PostMapping("/login")
    public String postLogin(@ModelAttribute User loginData, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (authenticationService.isAuthenticated(session)) {
            return "redirect:/";
        }

        String username = loginData.getUsername();
        String password = loginData.getPassword();
        String errorMessage = null;

        try {
            if (authenticationService.checkLoginData(username, password)) {
                authenticationService.loginUser(session, username);

                messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully logged in.");
                return "redirect:/";
            }
            errorMessage = "Incorrect password.";
        } catch (Exception e) {
            errorMessage = "No user with this username found.";
        }

        model.addAttribute("loginData", loginData);
        messageService.displayErrorMessage(model, errorMessage);
        System.out.println(errorMessage);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        authenticationService.logoutUser(session);
        return "redirect:/login";
    }
}
