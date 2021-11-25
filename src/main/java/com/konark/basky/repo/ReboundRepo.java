package com.konark.basky.repo;

import com.konark.basky.entity.Rebound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReboundRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Rebound getReboundById(int reboundId)
    {
        String sql = "SELECT * FROM reb" +
                "ound WHERE reboundId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Rebound.class) , new Object[] {reboundId});
    }
    public void createRebound(Rebound rebound)
    {
        String sql = "INSERT INTO rebound (time, playerId,matchId) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,rebound.getTime(),rebound.getPlayerId(),rebound.getMatchId());
    }
    public void update(Rebound rebound) {
        String sql = "UPDATE  rebound SET time =?, playerId =?,  matchId=? where reboundId=?";

        System.out.println(rebound.getPlayerId());
        jdbcTemplate.update(sql,rebound.getTime(),rebound.getPlayerId(),rebound.getMatchId());

    }
    public List<Rebound> getAllRebounds() {
        String sql = "SELECT * FROM rebound;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Rebound.class));
    }
}
