package com.konark.basky.service;

import com.konark.basky.entity.Basket;
import com.konark.basky.repo.BasketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    @Autowired
    private BasketRepo basketRepo;

    public void createBasket(Basket basket) {
        basketRepo.createBasket(basket);
    }

}
