package com.konark.basky.service;

import com.konark.basky.entity.Player;
import com.konark.basky.entity.Player;
import com.konark.basky.repo.PlayerRepo;
import com.konark.basky.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;
    public Object getPlayerById(int id){return playerRepo.getPlayerById(id);};

    public void createPlayer(Player player) {
        playerRepo.createPlayer(player);
    }

    public Object getAllPlayers() {
        return playerRepo.getAllPlayers();
    }

    public void updatePlayer(int playerId, Player player) {
        playerRepo.update(player);
    }
}