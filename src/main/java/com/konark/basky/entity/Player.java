package com.konark.basky.entity;


import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Player {
    private int playerId;
    private String firstName;
    private String lastName;
    private String PhoneNo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private int pin;
    private String city;
    private int houseNo;
    private String street;
    private int teamId;

    public Player(int playerId, String firstName, String lastName, String phoneNo, Date dob, int pin, String city, int houseNo, String street, int teamId) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        PhoneNo = phoneNo;
        this.dob = dob;
        this.pin = pin;
        this.city = city;
        this.houseNo = houseNo;
        this.street = street;
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PhoneNo=" + PhoneNo +
                ", dob=" + dob +
                ", pin=" + pin +
                ", city='" + city + '\'' +
                ", houseNo=" + houseNo +
                ", street='" + street + '\'' +
                ", teamId=" + teamId +
                '}';
    }

    public Player() {
    }
}
