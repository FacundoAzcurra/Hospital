package com.solvd.hospital.domain;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "rooms")
@XmlType(propOrder = { "idRooms", "floor", "doctorOfficeId", "available","medicId" })
public class Rooms {

    int idRooms;
    boolean isAvailable;
    int floor;
    int medicId;
    int doctorOfficeId;

    public Rooms() {
    }

    public Rooms(int idRooms, boolean isAvailable, int floor, int medicId,int doctorOfficeId) {
        this.idRooms = idRooms;
        this.isAvailable = isAvailable;
        this.floor = floor;
        this.medicId = medicId;
        this.doctorOfficeId = doctorOfficeId;
    }


    public int getDoctorOfficeId() {
        return doctorOfficeId;
    }
    @XmlElement(name="doctorOfficeId")
    public void setDoctorOfficeId(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }

    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }


    public int getidRooms() {
        return idRooms;
    }
    @XmlAttribute(name="idRooms")
    public void setidRooms(int idRooms) {
        this.idRooms = idRooms;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public int getFloor() {
        return floor;
    }

    @XmlElement(name="floor")
    public void setFloor(int floor) {
        this.floor = floor;
    }


    @Override
    public int hashCode() {
        return hashCode();
    }

    @Override
    public boolean equals(Object obj) { return equals(obj); }

    @Override
    public String toString() {
        return "Rooms{" +
                "idRooms=" + idRooms +
                ", isAvailable=" + isAvailable +
                ", floor=" + floor +
                ", medicId=" + medicId +
                ", doctorOfficeId=" + doctorOfficeId +
                '}';
    }
}

