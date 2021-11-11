package com.konark.basky.repo;

import com.konark.basky.entity.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrgRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Org getOrgById(int orgId)
    {
        String sql = "SELECT * FROM org WHERE orgId = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Org.class) , new Object[] {orgId});
    }
    public void createOrg(Org org)
    {
        String sql = "INSERT INTO org( firstName,lastName, phoneNo,dob,role) VALUES (?, ?, ?,?,?)";
        System.out.println(org.getRole());
        jdbcTemplate.update(sql,org.getFirstName(),org.getLastName(),org.getPhoneNo(),org.getDob(),org.getRole());
    }
    public void update(Org org) {
        String sql = "UPDATE  org SET firstName =?, lastName=?,phoneNo =?,  dob=? ,role=? where orgId=?";

        System.out.println(org.getFirstName());
        jdbcTemplate.update(sql,org.getFirstName(),org.getLastName(),org.getPhoneNo(),org.getDob(),org.getRole(),org.getOrgId());

    }
    public List<Org> getAllOrgs() {
        String sql = "SELECT * FROM org;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Org.class));
    }
}
