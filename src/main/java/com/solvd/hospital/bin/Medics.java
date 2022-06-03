package com.solvd.hospital.bin;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class Medics {
    int idMedics;
    String firstName;
    String lastName;
    int roomId;
    int doctorOfficeId;

    public Medics() {
    }

    public Medics(int idMedics, String firstName, String lastName, int roomId, int doctorOfficeId) {
        this.idMedics = idMedics;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomId = roomId;
        this.doctorOfficeId = doctorOfficeId;
    }

    public int getidMedics() {
        return idMedics;
    }

    public void setidMedics(int idMedics) {
        this.idMedics = idMedics;
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
        return "Medics{" +
                "idMedics=" + idMedics +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roomId=" + roomId +
                ", doctorOfficeId=" + doctorOfficeId +
                '}';
    }
}
