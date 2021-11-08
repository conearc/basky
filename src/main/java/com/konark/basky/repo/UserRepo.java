package com.konark.basky.repo;

import com.konark.basky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(String username)
    {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(User.class) , new Object[] {username});
    }

    public void createUser(String username,String password,String userType)
    {
        String sql = "INSERT INTO user (username, password, userType) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, username, password,userType);
    }

    public Boolean checkIfUserExists(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        List<User> userList = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<>(User.class) , new Object[] {username});
        if(userList.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}



