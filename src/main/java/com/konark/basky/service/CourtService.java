package com.konark.basky.service;

import com.konark.basky.entity.Court;
import com.konark.basky.repo.CourtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtService {
    @Autowired
    private CourtRepo courtRepo;
    public void createCourt(Court court) {
        courtRepo.createCourt(court);
    }

    public Object getAllCourts() {
        return courtRepo.getAllCourts();
    }

    public void updateCourt(int courtId, Court court) {
        courtRepo.update(court);
    }
}
