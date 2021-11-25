package com.konark.basky.service;

import com.konark.basky.entity.User;
import com.konark.basky.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepo userRepo;
    private String SESSION_AUTH_KEY = "AUTH_USER";

    public Boolean checkLoginData(String username, String password) {
        User user = userRepo.getUser(username);
        return user.getPassword().equals(password);
    }

    public void loginUser(HttpSession session, String username) {
        session.setAttribute(SESSION_AUTH_KEY, username);
    }

    public void logoutUser(HttpSession session) {
        session.removeAttribute(SESSION_AUTH_KEY);
    }

    public String getCurrentUser(HttpSession session) {
        try {
            return session.getAttribute(SESSION_AUTH_KEY).toString();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean isAuthenticated(HttpSession session) {
        return getCurrentUser(session) != null;
    }

    public String getUserType(HttpSession session) {
        try {
            return session.getAttribute("userType").toString();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean IsAdmin(HttpSession session) {
        return getUserType(session).equals("admin");
    }

    public Boolean IsCoach(HttpSession session) {
        return getUserType(session).equals("coach");
    }

}
