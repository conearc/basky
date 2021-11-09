package com.konark.basky.repo;

import com.konark.basky.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
    public Coach getCoachById(int coachId)
    {
        String sql = "SELECT * FROM coach WHERE coachId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Coach.class) , new Object[] {coachId});
    }
    public void createCoach(Coach coach)
    {
        String sql = "INSERT INTO coach( coachId, firstName,  lastName,  phoneNo,  dob,  pin,  city, houseNo,  street,  username) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, coach.getCoachId(), coach.getFirstName(),coach.getLastName(),coach.getPhoneNo(),coach.getDob(),coach.getPin(),coach.getCity(),coach.getHouseNo(),coach.getStreet(),coach.getUsername());
    }
    public void update(Coach coach) {
        String sql = "UPDATE coach SET firstName=?, lastName=?, phoneNo =?, dob=?, pin=?,city=?, houseNo=?, street=? WHERE id = ?";
        System.out.println(coach.getFirstName());
        jdbcTemplate.update(
                sql, coach.getFirstName(),coach.getLastName(),coach.getPhoneNo(),coach.getDob(),coach.getPin(),coach.getCity(),coach.getHouseNo(),coach.getStreet(),coach.getCoachId());
    }
    public List<Coach> getAllCoachs() {
        String sql = "SELECT * FROM coach;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Coach.class));
    }


}
