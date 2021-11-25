package com.konark.basky.repo;

import com.konark.basky.entity.Steal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StealRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Steal getStealById(int stealId)
    {
        String sql = "SELECT * FROM steal WHERE stealId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Steal.class) , new Object[] {stealId});
    }
    public void createSteal(Steal steal)
    {
        String sql = "INSERT INTO steal(time, playerId,matchId) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,steal.getTime(),steal.getPlayerId(),steal.getMatchId());
    }
    public void update(Steal steal) {
        String sql = "UPDATE  steal SET time =?, playerId =?,  matchId=? where stealId=?";

        System.out.println(steal.getPlayerId());
        jdbcTemplate.update(sql,steal.getTime(),steal.getPlayerId(),steal.getMatchId());

    }
    public List<Steal> getAllSteals() {
        String sql = "SELECT * FROM steal;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Steal.class));
    }
}
