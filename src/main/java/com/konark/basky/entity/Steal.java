package com.konark.basky.entity;

import java.sql.Time;

public class Steal {
    private int stealId;
    private Time time;
    private int PlayerId;
    private int MatchId;

    public Steal(int stealId, Time time, int playerId, int matchId) {
        this.stealId = stealId;
        this.time = time;
        PlayerId = playerId;
        MatchId = matchId;
    }

    public Steal() {
    }

    public int getStealId() {
        return stealId;
    }

    public void setStealId(int stealId) {
        this.stealId = stealId;
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
        return "Steal{" +
                "stealId=" + stealId +
                ", time=" + time +
                ", PlayerId=" + PlayerId +
                ", MatchId=" + MatchId +
                '}';
    }
}
