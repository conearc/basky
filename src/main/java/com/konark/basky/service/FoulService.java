package com.konark.basky.service;

import com.konark.basky.entity.Foul;
import com.konark.basky.repo.FoulRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoulService {
    @Autowired
    private FoulRepo foulRepo;


    public void createFoul(Foul foul) {
        foulRepo.createFoul(foul);
    }
}
