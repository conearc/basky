package com.konark.basky.service;

import com.konark.basky.entity.Coach;
import com.konark.basky.repo.CoachRepo;
import com.konark.basky.utils.Email;
import com.konark.basky.utils.UserPasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    @Autowired
    private CoachRepo coachRepo;

    @Autowired
    private UserPasswordGenerator userPasswordGenerator;

    @Autowired
    private Email email;

    @Autowired
    private UserService userService;

    public void createCoach(Coach coach)
    {
         Coach createdCoach = coachRepo.createCoach(coach);
         String username = "C"+createdCoach.getCoachId()+coach.getFirstName();
         String password = userPasswordGenerator.generatePassword();
         try {
             email.sendEmail(username, password, coach.getEmail());
         }
         catch (Exception e)
         {

         }
         userService.createCoach(username,password,coach);
         coach.setUsername(username);
         coachRepo.updateUsername(coach);

    }
}
