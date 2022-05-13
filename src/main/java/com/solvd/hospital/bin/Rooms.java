package com.solvd.hospital.bin;

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

    public int getDoctorOfficeId() {
        return doctorOfficeId;
    }

    public void setDoctorOfficeId(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }

    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

