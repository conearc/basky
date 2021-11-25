package com.konark.basky.repo;

import com.konark.basky.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
//    public void createCoach(Coach coach)
//    {
//        String sql = "INSERT INTO coach( coachId, firstName,  lastName,  phoneNo,  dob,  pin,  city, houseNo,  street) VALUES (?, ?, ?,?,?,?,?,?,?)";
//        jdbcTemplate.update(sql, coach.getCoachId(), coach.getFirstName(),coach.getLastName(),coach.getPhoneNo(),coach.getDob(),coach.getPin(),coach.getCity(),coach.getHouseNo(),coach.getStreet());
//    }

    public Coach createCoach(Coach coach) {
        String sql = "INSERT INTO coach ( firstName,  lastName, phoneNo, dob, pin, city,houseNo, street, email,teamId) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator(){
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[] {"coachId"});
                preparedStatement.setString(1,coach.getFirstName());

                preparedStatement.setString(2,coach.getLastName());
                preparedStatement.setString(3,coach.getPhoneNo());
                preparedStatement.setDate(4,  new java.sql.Date(coach.getDob().getTime()));
                preparedStatement.setInt(5,coach.getPin());
                preparedStatement.setString(6,coach.getCity());
                preparedStatement.setInt(7,coach.getHouseNo());
                preparedStatement.setString(8,coach.getStreet());
                preparedStatement.setString(9,coach.getEmail());
                preparedStatement.setInt(10,coach.getTeamId());

                return preparedStatement;
            }
        }, keyHolder);
        int coachId = keyHolder.getKey().intValue();
        coach.setCoachId(coachId);
        return coach;
    }
    
    public void update(Coach coach) {
        String sql = "UPDATE coach SET firstName=?, lastName=?, phoneNo =?, dob=?, pin=?,city=?, houseNo=?, street=? WHERE coachId = ?";
        System.out.println(coach.getFirstName());
        jdbcTemplate.update(
                sql, coach.getFirstName(),coach.getLastName(),coach.getPhoneNo(),coach.getDob(),coach.getPin(),coach.getCity(),coach.getHouseNo(),coach.getStreet(),coach.getCoachId());
    }
    public void updateUsername(Coach coach) {
        String sql = "UPDATE coach SET  username=? WHERE coachId = ?";
        System.out.println(coach.getFirstName());
        jdbcTemplate.update(
                sql,coach.getUsername(),coach.getCoachId());
    }
    public List<Coach> getAllCoachs() {
        String sql = "SELECT * FROM coach;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Coach.class));
    }


}
