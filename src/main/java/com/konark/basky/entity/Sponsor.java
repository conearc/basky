package com.konark.basky.entity;

public class Sponsor {
    private int sponsorId;
    private String name;
    private String phoneNo;
    private String email;

    public Sponsor(int sponsorId, String name, String phoneNo, String email) {
        this.sponsorId = sponsorId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Sponsor() {
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "sponsorId=" + sponsorId +
                ", name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                ", email='" + email + '\'' +
                '}';
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
