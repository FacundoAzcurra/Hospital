package com.solvd.hospital.binary;

public class Chirophane {
    int chirophaneId;
    boolean isAvailable;
    int floor;
    int chirophaneRoomID;

    public Chirophane() {
    }

    public Chirophane(int chirophaneId, boolean isAvailable, int floor, int chirophaneRoomID) {
        this.chirophaneId = chirophaneId;
        this.isAvailable = isAvailable;
        this.floor = floor;
        this.chirophaneRoomID = chirophaneRoomID;
    }

    public int getChirophaneId() {
        return chirophaneId;
    }

    public void setChirophaneId(int chirophaneId) {
        this.chirophaneId = chirophaneId;
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

    public int getChirophaneRoom() {
        return chirophaneRoomID;
    }

    public void setChirophaneRoom(int chirophaneRoom) {
        this.chirophaneRoomID = chirophaneRoomID;
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
        return toString();
    }
}
