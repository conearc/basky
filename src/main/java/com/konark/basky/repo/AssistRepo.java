package com.konark.basky.repo;

import com.konark.basky.entity.Assist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssistRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Assist getAssistById(int assistId)
    {
        String sql = "SELECT * FROM assist WHERE assistId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Assist.class) , new Object[] {assistId});
    }
    public void createAssist(Assist assist)
    {
        String sql = "INSERT INTO assist(time, playerId,matchId) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,assist.getTime(),assist.getPlayerId(),assist.getMatchId());
    }
    public void update(Assist assist) {
        String sql = "UPDATE  assist SET time =?, playerId =?,  matchId=? where assistId=?";

        System.out.println(assist.getPlayerId());
        jdbcTemplate.update(sql,assist.getTime(),assist.getPlayerId(),assist.getMatchId());

    }
    public List<Assist> getAllAssists() {
        String sql = "SELECT * FROM assist;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Assist.class));
    }
}
