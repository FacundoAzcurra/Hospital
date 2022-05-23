package com.solvd.hospital.bin;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "rooms")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"roomId", "floor", "medicId","doctorOfficeId","isAvailable"})
public class Rooms {

    int roomId;
    boolean isAvailable;
    int floor;
    int medicId;
    int doctorOfficeId;

    public Rooms() {
    }

    public Rooms(int roomId, boolean isAvailable, int floor, int medicId,int doctorOfficeId) {
        this.roomId = roomId;
        this.isAvailable = isAvailable;
        this.floor = floor;
        this.medicId = medicId;
        this.doctorOfficeId = doctorOfficeId;
    }

    @XmlElement(name="doctorOfficeId")
    public int getDoctorOfficeId() {
        return doctorOfficeId;
    }

    public void setDoctorOfficeId(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }
    @XmlElement(name="medicId")
    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    @XmlAttribute(name="roomId")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @XmlElement(name="isAvailable")
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @XmlElement(name="floor")
    public int getFloor() {
        return floor;
    }

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
        return toString();
    }

}

