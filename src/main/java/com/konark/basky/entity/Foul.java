package com.konark.basky.entity;

import java.sql.Time;

public class Foul {
    private int foulId;
    private Time time;
    private int playerId;
    private int matchId;
    private int umpireId;
    private String description;

    public Foul(int foulId, Time time, int playerId, int matchId, int umpireId, String description) {
        this.foulId = foulId;
        this.time = time;
        this.playerId = playerId;
        this.matchId = matchId;
        this.umpireId = umpireId;
        this.description = description;
    }

    public Foul() {
    }

    public int getFoulId() {
        return foulId;
    }

    public void setFoulId(int foulId) {
        this.foulId = foulId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getUmpireId() {
        return umpireId;
    }

    public void setUmpireId(int umpireId) {
        this.umpireId = umpireId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Foul{" +
                "foulId=" + foulId +
                ", time=" + time +
                ", playerId=" + playerId +
                ", matchId=" + matchId +
                ", umpireId=" + umpireId +
                ", description='" + description + '\'' +
                '}';
    }
}
