package com.konark.basky.service;

import com.konark.basky.entity.Sponsor;
import com.konark.basky.repo.SponsorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorService {
    @Autowired
    private SponsorRepo sponsorRepo;

    public void createSponsor(Sponsor sponsor) {
        sponsorRepo.createSponsor(sponsor);
    }

    public Object getAllSponsors() {
        return sponsorRepo.getAllSponsors();
    }

    public void updateSponsor(int sponsorId, Sponsor sponsor) {
        sponsorRepo.update(sponsor);
    }
}
