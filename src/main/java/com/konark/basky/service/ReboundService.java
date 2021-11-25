package com.konark.basky.service;

import com.konark.basky.entity.Rebound;
import com.konark.basky.repo.ReboundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReboundService {
    @Autowired
    private ReboundRepo reboundRepo;
    public void createRebound(Rebound rebound) {
        reboundRepo.createRebound(rebound);
    }
}
