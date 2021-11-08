package com.konark.basky.entity;

import java.sql.Time;

public class Basket {
    private int basketId;
    private Time time;
    private int PlayerId;
    private int MatchId;

    public Basket(int basketId, Time time, int playerId, int matchId) {
        this.basketId = basketId;
        this.time = time;
        PlayerId = playerId;
        MatchId = matchId;
    }

    public Basket() {
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
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
        return "Basket{" +
                "basketId=" + basketId +
                ", time=" + time +
                ", PlayerId=" + PlayerId +
                ", MatchId=" + MatchId +
                '}';
    }
}
