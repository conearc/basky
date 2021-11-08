package com.konark.basky.service;

import com.konark.basky.entity.Coach;
import com.konark.basky.repo.CoachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    @Autowired
    private CoachRepo coachRepo;
    public void createCoach(Coach coach)
    {
         coachRepo.createCoach( coach);
    }
}
