package com.konark.basky.service;

import com.konark.basky.entity.Coach;
import com.konark.basky.entity.User;
import com.konark.basky.repo.CoachRepo;
import com.konark.basky.repo.PlayerRepo;
import com.konark.basky.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserRepo userRepo;
    @Autowired CoachRepo coachRepo;

    public Boolean checkIfUserExists(String username) {
        return userRepo.checkIfUserExists(username);
    }

    public void createAdmin(String username, String password)
    {
        userRepo.createUser(username,password,"admin");
    }
    public void createCoach(String username, String password, Coach coach)
    {
        userRepo.createUser(username,password,"coach");
        coach.setUsername(username);
        coachRepo.createCoach(coach);
    }


}
