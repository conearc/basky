package com.konark.basky.entity;

import java.sql.Time;

public class Block {
    private int blockId;
    private Time time;
    private int PlayerId;
    private int MatchId;

    public Block(int blockId, Time time, int playerId, int matchId) {
        this.blockId = blockId;
        this.time = time;
        PlayerId = playerId;
        MatchId = matchId;
    }

    public Block() {
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
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
        return "Block{" +
                "blockId=" + blockId +
                ", time=" + time +
                ", PlayerId=" + PlayerId +
                ", MatchId=" + MatchId +
                '}';
    }
}
