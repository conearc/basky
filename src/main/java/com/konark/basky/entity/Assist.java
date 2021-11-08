package com.konark.basky.entity;

import java.sql.Time;

public class Assist {
    private int assistId;
    private Time time;
    private int PlayerId;
    private int MatchId;

    public Assist(int assistId, Time time, int playerId, int matchId) {
        this.assistId = assistId;
        this.time = time;
        PlayerId = playerId;
        MatchId = matchId;
    }

    public Assist() {
    }

    public int getAssistId() {
        return assistId;
    }

    public void setAssistId(int assistId) {
        this.assistId = assistId;
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
        return "Assist{" +
                "assistId=" + assistId +
                ", time=" + time +
                ", PlayerId=" + PlayerId +
                ", MatchId=" + MatchId +
                '}';
    }
}
