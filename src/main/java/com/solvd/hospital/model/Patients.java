package com.solvd.hospital.model;

public class Patients {
    int patientsId;
    boolean isAttendend;
    String firstName;
    String lastName;
    int healthCareId;

    public Patients() {
    }

    public Patients(int patientsId, boolean isAttendend, String firstName, String lastName, int healthCareId) {
        this.patientsId = patientsId;
        this.isAttendend = isAttendend;
        this.firstName = firstName;
        this.lastName = lastName;
        this.healthCareId = healthCareId;
    }

    public int getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(int patientsId) {
        this.patientsId = patientsId;
    }

    public boolean isAttendend() {
        return isAttendend;
    }

    public void setAttendend(boolean attendend) {
        isAttendend = attendend;
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

    public int getHealthCareId() {
        return healthCareId;
    }

    public void setHealthCareId(int healthCareId) {
        this.healthCareId = healthCareId;
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
