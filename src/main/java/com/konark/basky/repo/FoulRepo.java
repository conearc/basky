package com.konark.basky.repo;

import com.konark.basky.entity.Foul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoulRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Foul getFoulById(int foulId)
    {
        String sql = "SELECT * FROM foul WHERE foulId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Foul.class) , new Object[] {foulId});
    }
    public void createFoul(Foul foul)
    {
        String sql = "INSERT INTO foul(time, description, playerId,matchId,umpireId) VALUES (?, ?, ?,?,?)";
        jdbcTemplate.update(sql,foul.getTime(),foul.getPlayerId(),foul.getMatchId());
    }
    public void update(Foul foul) {
        String sql = "UPDATE  foul SET time =?, description=?,playerId =?,  matchId=?, umpireId=? where foulId=?";

        System.out.println(foul.getPlayerId());
        jdbcTemplate.update(sql,foul.getTime(),foul.getDescription(),foul.getPlayerId(),foul.getMatchId(), foul.getUmpireId());

    }
    public List<Foul> getAllFouls() {
        String sql = "SELECT * FROM foul;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Foul.class));
    }
}
