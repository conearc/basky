package com.konark.basky.repo;

import com.konark.basky.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Basket getBasketById(int basketId)
    {
        String sql = "SELECT * FROM basket WHERE basketId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Basket.class) , new Object[] {basketId});
    }
    public void createBasket(Basket basket)
    {
        String sql = "INSERT INTO basket(  time , playerId , matchId , value) VALUES ( ? , ?, ? , ?)";
        jdbcTemplate.update(sql,basket.getTime(),basket.getPlayerId(),basket.getMatchId(), basket.getValue());
    }
    public void update(Basket basket) {
        String sql = "UPDATE  basket SET time =?, playerId =?,  matchId=? ,value=? where basketId=?";

        System.out.println(basket.getPlayerId());
        jdbcTemplate.update(sql,basket.getTime(),basket.getPlayerId(),basket.getMatchId(),basket.getValue(), basket.getBasketId());

    }
    public List<Basket> getAllBaskets() {
        String sql = "SELECT * FROM basket;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Basket.class));
    }
    public List<Basket> getBasketsMatch(int matchId) {
        String sql = "SELECT * FROM basket where matchId=?;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Basket.class),new Object[] {matchId});
    }
}
