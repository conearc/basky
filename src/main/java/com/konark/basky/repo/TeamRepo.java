package com.konark.basky.repo;

import com.konark.basky.entity.Team;
import com.konark.basky.entity.Team;
import com.konark.basky.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Team getTeam(int  teamId)
    {
        String sql = "SELECT * FROM team WHERE teamId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Team.class) , new Object[] {teamId});
    }
    public void createTeam(Team team)
    {
        String sql = "INSERT INTO team(  teamName,  phoneNo,  state,   city,pin) VALUES (?, ?, ?,?,?)";
        jdbcTemplate.update(sql, team.getTeamName(), team.getPhoneNo(), team.getState(), team.getCity(),team.getPin());
    }
    public Boolean checkIfTeamExists(String teamName) {
        String sql = "SELECT * FROM team WHERE teamName = ?";
        List<Team> teamList = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<>(Team.class) , new Object[] {teamName});
        if(teamList.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public List<Team> getAllTeams() {
        String sql = "SELECT * FROM team;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Team.class));
    }
    public void update(Team team) {
        String sql = "UPDATE team SET teamName=?, phoneNo=?, state =?, city=?, pin=? WHERE teamId = ?";
        System.out.println(team.getTeamName());
        jdbcTemplate.update(
                sql, team.getTeamName(),  team.getPhoneNo(),team.getState(),team.getCity(),team.getPin(),team.getTeamId());
    }
}
