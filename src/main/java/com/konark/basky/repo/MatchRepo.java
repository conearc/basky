package com.konark.basky.repo;

import com.konark.basky.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
//
    public Match getMatchById(int matchId)
    {
        String sql = "SELECT * FROM basky.match WHERE matchId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Match.class) , new Object[] {matchId});
    }
    public void createMatch(Match match)
    {
        String sql = "INSERT INTO match(   team1Id,  team2Id,  umpireId,  sponsorId,  orgId,  courtId,   date) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,match.getTeam1Id(),match.getTeam2Id(),match.getUmpireId(),match.getSponsorId(),match.getOrgId(),match.getCourtId(),match.getDate());
    }
    public void update(Match match) {
        String sql = "UPDATE  basky.match SET team1Id =?, team2Id =?,  team1Score=?,  team2Score=?,  umpireId=?,  sponsorId=?,  orgId=?,  courtId=? ,  manOfMatch=?, isFinished=?, date=? where matchId=?";

        System.out.println(match.getTeam1Id());
        jdbcTemplate.update(sql,match.getTeam1Id(),match.getTeam2Id(),match.getTeam1Score(),match.getTeam2Score(),match.getUmpireId(),match.getSponsorId(),match.getOrgId(),match.getCourtId(),match.getManOfMatch(),match.isFinished(),match.getDate(),match.getMatchId());

    }
    public List<Match> getAllMatchs() {
        String sql = "SELECT * FROM basky.match;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Match.class));
    }
    public List<Match> getRunningMatchs() {
        String sql = "SELECT * FROM basky.match where date <= CURRENT_TIMESTAMP and isFinished = 0 ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Match.class));
    }
    public List<Match> getFinishedMatchs() {
        String sql = "SELECT * FROM basky.match where isFinished = 1 ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Match.class));
    }
    public List<Match> getUpcomingMatchs() {
        String sql = "SELECT * FROM basky.match where date > CURRENT_TIMESTAMP and isFinished = 0 ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Match.class));
    }
}
