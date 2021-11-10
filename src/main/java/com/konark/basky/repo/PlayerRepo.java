package com.konark.basky.repo;

import com.konark.basky.entity.Player;
import com.konark.basky.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Player getPlayerById(int playerId)
    {
        String sql = "SELECT * FROM player WHERE playerId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Player.class) , new Object[] {playerId});
    }
    public void createPlayer(Player player)
    {
        String sql = "INSERT INTO player(  firstName, lastName,  phoneNo,  dob,  pin,  city,  houseNo,  street,  teamId) VALUES (?, ?, ?,?,?,?,?,?,?)";
        System.out.println(player.getPlayerId());
        jdbcTemplate.update(sql,player.getFirstName(),player.getLastName(),player.getPhoneNo(),player.getDob(),player.getPin(),player.getCity(),player.getHouseNo(),player.getStreet(),player.getTeamId());
    }
    public void update(Player player) {

        String sql = "UPDATE  player SET firstName =?, lastName =?,  phoneNo=?,  dob=?,  pin=?,  city=?,  houseNo=?,  street=? ,teamId=? where playerId=?";
        System.out.println(player.getPlayerId());
        System.out.println(player.getFirstName());
        jdbcTemplate.update(sql,player.getFirstName(),player.getLastName(),player.getPhoneNo(),player.getDob(),player.getPin(),player.getCity(),player.getHouseNo(),player.getStreet(),player.getTeamId(),player.getPlayerId());

    }
    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM player;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Player.class));
    }
}
