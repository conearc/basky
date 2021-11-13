package com.konark.basky.service;

import com.konark.basky.repo.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    @Autowired
    private MatchRepo matchRepo;

    public Object getMatchById(int id){return matchRepo.getMatchById(id);};
    public Object getAllMatchs() {
        return matchRepo.getAllMatchs();
    }
}
