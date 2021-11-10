package com.konark.basky.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Umpire {
    private int umpireId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    private int pin;
    private String city;
    private int houseNo;
    private String street;

    public Umpire(int umpireId, String firstName, String lastName, String phoneNo, Date dob, int pin, String city, int houseNo, String street) {
        this.umpireId = umpireId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.pin = pin;
        this.city = city;
        this.houseNo = houseNo;
        this.street = street;
    }

    public Umpire() {
    }

    public int getUmpireId() {
        return umpireId;
    }

    public void setUmpireId(int umpireId) {
        this.umpireId = umpireId;
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

    @Override
    public String toString() {
        return "Umpire{" +
                "umpireId=" + umpireId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo=" + phoneNo +
                ", dob=" + dob +
                ", pin=" + pin +
                ", city='" + city + '\'' +
                ", houseNo=" + houseNo +
                ", street='" + street + '\'' +
                '}';
    }
}
