package com.konark.basky.service;

import com.konark.basky.entity.Org;
import com.konark.basky.repo.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {
    @Autowired
    private OrgRepo orgRepo;

    public void createOrg(Org org) {
        orgRepo.createOrg(org);
    }

    public Object getAllOrgs() {
        return orgRepo.getAllOrgs();
    }

    public void updateOrg(int orgId, Org org) {
        orgRepo.update(org);
    }
}
