package com.konark.basky.entity;

public class Team {
    private int teamId;
    private String teamName;
    private String phoneNo;
    private String state;
    private String city;
    private int pin;
    private int numberOfWins;
    private int numberOfLosses;
    private int pointsScored;
    private int pointsAgainst;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    public Team(int teamId, String teamName, String phoneNo, String state, String city, int pin, int numberOfWins, int numberOfLosses, int pointsScored, int pointsAgainst) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.phoneNo = phoneNo;
        this.state = state;
        this.city = city;
        this.pin = pin;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.pointsScored = pointsScored;
        this.pointsAgainst = pointsAgainst;
    }

    public Team() {
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", phoneNo=" + phoneNo +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pin=" + pin +
                ", numberOfWins=" + numberOfWins +
                ", numberOfLosses=" + numberOfLosses +
                ", pointsScored=" + pointsScored +
                ", pointsAgainst=" + pointsAgainst +
                '}';
    }
}
