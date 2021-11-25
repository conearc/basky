package com.konark.basky.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDateTime;

public class Assist {
    private int assistId;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime time;
    private int PlayerId;
    private int MatchId;

    public int getAssistId() {
        return assistId;
    }

    public void setAssistId(int assistId) {
        this.assistId = assistId;
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
