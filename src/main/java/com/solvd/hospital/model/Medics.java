package com.solvd.hospital.model;

public class Medics {
    int medicId;
    String firstName;
    String lastName;
    int roomId;
    int doctorOfficeId;

    public Medics() {
    }

    public Medics(int medicId, String firstName, String lastName, int roomId, int doctorOfficeId) {
        this.medicId = medicId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomId = roomId;
        this.doctorOfficeId = doctorOfficeId;
    }

    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getDoctorOfficeId() {
        return doctorOfficeId;
    }

    public void setDoctorOfficeId(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }
}
