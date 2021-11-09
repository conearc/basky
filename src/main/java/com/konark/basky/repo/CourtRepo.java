package com.konark.basky.repo;

import com.konark.basky.entity.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourtRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Court getCourtById(int courtId)
    {
        String sql = "SELECT * FROM court WHERE courtId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Court.class) , new Object[] {courtId});
    }
    public void createCourt(Court court)
    {
        String sql = "INSERT INTO court( courtName, landmark,capacity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,court.getCourtName(),court.getLandmark(),court.getCapacity());
    }
    public void update(Court court) {
        String sql = "UPDATE  court SET courtName =?, landmark =?,  capacity=? where courtId=?";

        System.out.println(court.getCourtName());
        jdbcTemplate.update(sql,court.getCourtName(),court.getLandmark(),court.getCapacity());

    }
    public List<Court> getAllCourts() {
        String sql = "SELECT * FROM court;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Court.class));
    }
}
