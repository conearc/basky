package com.konark.basky.service;

import com.konark.basky.entity.Block;
import com.konark.basky.repo.BlockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    @Autowired
    private BlockRepo blockRepo;
    public void createBlock(Block block) {
        blockRepo.createBlock(block);

    }
}
