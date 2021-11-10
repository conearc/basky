package com.konark.basky.repo;

import com.konark.basky.entity.Umpire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UmpireRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Umpire getUmpireById(int umpireId)
    {
        String sql = "SELECT * FROM umpire WHERE umpireId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Umpire.class) , new Object[] {umpireId});
    }
    public void createUmpire(Umpire umpire)
    {
        String sql = "INSERT INTO umpire( firstName, lastName,  phoneNo,  dob, pin, city, houseNo, street) VALUES (?, ?, ?,?,?,?,?,?)";
        jdbcTemplate.update(sql,umpire.getFirstName(),umpire.getLastName(),umpire.getPhoneNo(),umpire.getDob(),umpire.getPin(),umpire.getCity(),umpire.getHouseNo(),umpire.getStreet());
    }
    public void update(Umpire umpire) {
        String sql = "UPDATE  umpire SET firstName =?, lastName =?,  phoneNo=?,  dob=?,  pin=?,  city=?,  houseNo=?,  street=? where umpireId=?";

        System.out.println(umpire.getFirstName());
        jdbcTemplate.update(sql,umpire.getFirstName(),umpire.getLastName(),umpire.getPhoneNo(),umpire.getDob(),umpire.getPin(),umpire.getCity(),umpire.getHouseNo(),umpire.getStreet(),umpire.getUmpireId());

    }
    public List<Umpire> getAllUmpires() {
        String sql = "SELECT * FROM umpire;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Umpire.class));
    }
}
