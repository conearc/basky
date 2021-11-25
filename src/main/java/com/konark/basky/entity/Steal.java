package com.konark.basky.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDateTime;

public class Steal {
    private int stealId;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private int PlayerId;
    private int MatchId;

    public int getStealId() {
        return stealId;
    }

    public void setStealId(int stealId) {
        this.stealId = stealId;
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
}
