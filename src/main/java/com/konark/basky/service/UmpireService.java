package com.konark.basky.service;

import com.konark.basky.entity.Umpire;
import com.konark.basky.repo.UmpireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmpireService {
    @Autowired
    private UmpireRepo umpireRepo;
    public void createUmpire(Umpire umpire) {
        umpireRepo.createUmpire(umpire);

    }

    public Object getAllUmpires() {
        return umpireRepo.getAllUmpires();
    }

    public void updateUmpire(int umpireId, Umpire umpire) {
        umpireRepo.update(umpire);
    }
}
