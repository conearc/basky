package com.konark.basky.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDateTime;

public class Foul {
    private int foulId;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;

    private int playerId;
    private int matchId;
    private int umpireId;
    private String description;

    public int getFoulId() {
        return foulId;
    }

    public void setFoulId(int foulId) {
        this.foulId = foulId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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
}
