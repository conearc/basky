package com.konark.basky.entity;

public class Court {
    private int courtId;
    private String courtName;
    private String landmark;
    private int capacity;

    public Court(int courtId, String courtName, String landmark, int capacity) {
        this.courtId = courtId;
        this.courtName = courtName;
        this.landmark = landmark;
        this.capacity = capacity;
    }

    public Court() {
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Court{" +
                "courtId=" + courtId +
                ", courtName='" + courtName + '\'' +
                ", landmark='" + landmark + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}
