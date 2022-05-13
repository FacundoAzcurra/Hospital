package com.solvd.hospital.model;

public class AmbulanceDriver {
    int ambulanceDriverId;
    boolean hasPcrKnowledge;
    String firstName;
    String lastName;

    public AmbulanceDriver() {
    }

    public AmbulanceDriver(int ambulanceDriverId, boolean hasPcrKnowledge, String firstName, String lastName) {
        this.ambulanceDriverId = ambulanceDriverId;
        this.hasPcrKnowledge = hasPcrKnowledge;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAmbulanceDriverId() {
        return ambulanceDriverId;
    }

    public void setAmbulanceDriverId(int ambulanceDriverId) {
        this.ambulanceDriverId = ambulanceDriverId;
    }

    public boolean isHasPcrKnowledge() {
        return hasPcrKnowledge;
    }

    public void setHasPcrKnowledge(boolean hasPcrKnowledge) {
        this.hasPcrKnowledge = hasPcrKnowledge;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
