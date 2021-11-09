package com.konark.basky.repo;

import com.konark.basky.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlockRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Block getBlockById(int blockId)
    {
        String sql = "SELECT * FROM block WHERE blockId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Block.class) , new Object[] {blockId});
    }
    public void createBlock(Block block)
    {
        String sql = "INSERT INTO block(time, playerId,,matchId) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,block.getTime(),block.getPlayerId(),block.getMatchId());
    }
    public void update(Block block) {
        String sql = "UPDATE  block SET time =?, playerId =?,  matchId=? where blockId=?";

        System.out.println(block.getPlayerId());
        jdbcTemplate.update(sql,block.getTime(),block.getPlayerId(),block.getMatchId());

    }
    public List<Block> getAllBlocks() {
        String sql = "SELECT * FROM block;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Block.class));
    }
}
