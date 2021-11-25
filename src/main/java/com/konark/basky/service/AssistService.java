package com.konark.basky.service;

import com.konark.basky.entity.Assist;
import com.konark.basky.repo.AssistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssistService {
    @Autowired
    private AssistRepo assistRepo;
    public void createAssist(Assist assist) {
         assistRepo.createAssist(assist);
    }
}
