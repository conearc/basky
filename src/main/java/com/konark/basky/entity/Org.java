package com.konark.basky.entity;

import java.util.Date;

public class Org {
    private int orgId;
    private int firstname;
    private int LastName;
    private String phoneNo;
    private Date dob;
    private String role;

    public Org(int orgId, int firstname, int lastName, String phoneNo, Date dob, String role) {
        this.orgId = orgId;
        this.firstname = firstname;
        LastName = lastName;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.role = role;
    }

    public Org() {
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getFirstname() {
        return firstname;
    }

    public void setFirstname(int firstname) {
        this.firstname = firstname;
    }

    public int getLastName() {
        return LastName;
    }

    public void setLastName(int lastName) {
        LastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Org{" +
                "orgId=" + orgId +
                ", firstname=" + firstname +
                ", LastName=" + LastName +
                ", phoneNo=" + phoneNo +
                ", dob=" + dob +
                ", role='" + role + '\'' +
                '}';
    }
}
