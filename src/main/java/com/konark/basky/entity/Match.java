package com.konark.basky.entity;


public class Match {
    private int matchId;
    private int team1Id;
    private int team2Id;
    private int team1Score;
    private int team2Score;
    private int umpireId;
    private int sponsorId;
    private int orgId;
    private int courtId;
    private int manOfMatch;

    public Match(int matchId, int team1Id, int team2Id, int team1Score, int team2Score, int umpireId, int sponsorId, int orgId, int courtId, int manOfMatch) {
        this.matchId = matchId;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.umpireId = umpireId;
        this.sponsorId = sponsorId;
        this.orgId = orgId;
        this.courtId = courtId;
        this.manOfMatch = manOfMatch;
    }

    public Match() {
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(int team1Id) {
        this.team1Id = team1Id;
    }

    public int getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(int team2Id) {
        this.team2Id = team2Id;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public int getUmpireId() {
        return umpireId;
    }

    public void setUmpireId(int umpireId) {
        this.umpireId = umpireId;
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getManOfMatch() {
        return manOfMatch;
    }

    public void setManOfMatch(int manOfMatch) {
        this.manOfMatch = manOfMatch;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", team1Id=" + team1Id +
                ", team2Id=" + team2Id +
                ", team1Score=" + team1Score +
                ", team2Score=" + team2Score +
                ", umpireId=" + umpireId +
                ", sponsorId=" + sponsorId +
                ", orgId=" + orgId +
                ", courtId=" + courtId +
                ", manOfMatch=" + manOfMatch +
                '}';
    }
}
