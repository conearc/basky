package com.konark.basky.repo;

import com.konark.basky.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SponsorRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Sponsor getSponsorById(int sponsorId)
    {
        String sql = "SELECT * FROM sponsor WHERE sponsorId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Sponsor.class) , new Object[] {sponsorId});
    }
    public void createSponsor(Sponsor sponsor)
    {
        String sql = "INSERT INTO sponsor( name, phoneNo,email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,sponsor.getSponsorName(),sponsor.getPhoneNo(),sponsor.getEmail());
    }
    public void update(Sponsor sponsor) {
        String sql = "UPDATE  sponsor SET name =?, phoneNo =?,  email=? where sponsorId=?";

        System.out.println(sponsor.getSponsorName());
        jdbcTemplate.update(sql,sponsor.getSponsorName(),sponsor.getPhoneNo(),sponsor.getEmail());

    }
    public List<Sponsor> getAllSponsors() {
        String sql = "SELECT * FROM sponsor;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Sponsor.class));
    }
}
