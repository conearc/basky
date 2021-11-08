package com.konark.basky.entity;

import java.sql.Time;

public class Rebound {
    private int reboundId;
    private Time time;
    private int PlayerId;
    private int MatchId;

    public Rebound(int reboundId, Time time, int playerId, int matchId) {
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
