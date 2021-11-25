package com.konark.basky.repo;

import com.konark.basky.entity.Interest;
import com.konark.basky.entity.Interest;
import com.konark.basky.entity.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InterestRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createInterest(Interest interest)
    {
        String sql = "INSERT INTO interest(  firstName, lastName,  phoneNo, teamName, email) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, interest.getFirstName(), interest.getLastName(), interest.getPhoneNo(), interest.getTeamName(), interest.getEmail());
    }
    public Interest getInterest(int  interestId)
    {
        String sql = "SELECT * FROM interest WHERE interestId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Interest.class) , new Object[] {interestId});
    }
    public List<Interest> getAllInterests() {
        String sql = "SELECT * FROM interest;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Interest.class));
    }

    public void deleteInterest(int id) {
        String sql = "DELETE FROM interest WHERE interestId = ?";
        jdbcTemplate.update(sql, id);
    }
}
