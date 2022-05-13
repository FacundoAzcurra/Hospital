package com.solvd.hospital.model;

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
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
