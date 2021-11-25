package com.konark.basky.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDateTime;

public class Rebound {
    private int reboundId;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private int PlayerId;
    private int MatchId;

    public Rebound(int reboundId, LocalDateTime time, int playerId, int matchId) {
        this.reboundId = reboundId;
        this.time = time;
        PlayerId = playerId;
        MatchId = matchId;
    }

    public Rebound() {
    }

    public int getReboundId() {
        return reboundId;
    }

    public void setReboundId(int reboundId) {
        this.reboundId = reboundId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int playerId) {
        PlayerId = playerId;
    }

    public int getMatchId() {
        return MatchId;
    }

    public void setMatchId(int matchId) {
        MatchId = matchId;
    }

    @Override
    public String toString() {
        return "Rebound{" +
                "reboundId=" + reboundId +
                ", time=" + time +
                ", PlayerId=" + PlayerId +
                ", MatchId=" + MatchId +
                '}';
    }
}
