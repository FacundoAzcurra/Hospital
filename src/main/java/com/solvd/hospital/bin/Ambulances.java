package com.solvd.hospital.bin;

public class Ambulances {
    int ambulanceId;
    int ambulanceDriverId;

    public Ambulances() {
    }

    public Ambulances(int ambulanceId, int ambulanceDriverId) {
        this.ambulanceId = ambulanceId;
        this.ambulanceDriverId = ambulanceDriverId;
    }

    public int getAmbulanceId() {
        return ambulanceId;
    }

    public void setAmbulanceId(int ambulanceId) {
        this.ambulanceId = ambulanceId;
    }

    public int getAmbulanceDriverId() {
        return ambulanceDriverId;
    }

    public void setAmbulanceDriverId(int ambulanceDriverId) {
        this.ambulanceDriverId = ambulanceDriverId;
    }

    @Override
    public int hashCode() {
        return hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return equals(obj);
    }

    @Override
    public String toString() {
        return "Ambulances{" +
                "ambulanceId=" + ambulanceId +
                ", ambulanceDriverId=" + ambulanceDriverId +
                '}';
    }
}

