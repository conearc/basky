package com.konark.basky.service;

import com.konark.basky.entity.Steal;
import com.konark.basky.repo.StealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StealService {
    @Autowired
    private StealRepo stealRepo;
    public void createSteal(Steal steal) {
        stealRepo.createSteal(steal);
    }
}
