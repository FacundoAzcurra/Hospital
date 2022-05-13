package com.solvd.hospital.model;

public class Rooms {
    int roomId;
    boolean isAvailable;
    int floor;
    int medicId;

    public Rooms() {
    }

    public Rooms(int roomId, boolean isAvailable, int floor, int medicId) {
        this.roomId = roomId;
        this.isAvailable = isAvailable;
        this.floor = floor;
        this.medicId = medicId;
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
}
