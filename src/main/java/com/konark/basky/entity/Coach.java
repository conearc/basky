package com.konark.basky.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Coach {
    private int CoachId;
    private String firstName;
    private  String lastName;
    private String phoneNo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;
    private int pin;
    private String city;
    private int houseNo;
    private String street;
    private int teamId;
    private String username;

    public int getCoachId() {
        return CoachId;
    }

    public void setCoachId(int coachId) {
        CoachId = coachId;
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
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Coach() {
    }

    public Coach(int coachId, String firstName, String lastName, String phoneNo, LocalDate dob, int pin, String city, int houseNo, String street, int teamId, String username) {
        CoachId = coachId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.pin = pin;
        this.city = city;
        this.houseNo = houseNo;
        this.street = street;
        this.teamId = teamId;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "CoachId=" + CoachId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", dob=" + dob +
                ", pin=" + pin +
                ", city='" + city + '\'' +
                ", houseNo=" + houseNo +
                ", street='" + street + '\'' +
                ", teamId=" + teamId +
                ", username='" + username + '\'' +
                '}';
    }
}
