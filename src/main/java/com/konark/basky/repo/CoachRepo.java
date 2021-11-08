package com.konark.basky.repo;

import com.konark.basky.entity.Coach;
import com.konark.basky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CoachRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Coach getCoach(String username)
    {
        String sql = "SELECT * FROM coach WHERE username = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Coach.class) , new Object[] {username});
    }
    public void createCoach(Coach coach)
    {
        String sql = "INSERT INTO coach( coachId, firstName,  lastName,  phoneNo,  dob,  pin,  city, houseNo,  street,  username) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, coach.getCoachId(), coach.getFirstName(),coach.getLastName(),coach.getPhoneNo(),coach.getDob(),coach.getPin(),coach.getCity(),coach.getHouseNo(),coach.getStreet(),coach.getUsername());
    }


}
