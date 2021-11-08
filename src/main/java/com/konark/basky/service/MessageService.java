package com.konark.basky.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class MessageService {
    public void displayErrorMessage(Model model, String message) {
        model.addAttribute("errorMessage", message);
    }

    public void displaySuccessMessage(Model model, String message) {
        model.addAttribute("successMessage", message);
    }

    public void redirectWithErrorMessage(RedirectAttributes attributes, String message) {
        attributes.addFlashAttribute("errorMessage", message);
    }

    public void redirectWithSuccessMessage(RedirectAttributes attributes, String message) {
        attributes.addFlashAttribute("successMessage", message);
    }
}
