package com.solvd.hospital.model;

public class DeliveryRooms {
    int deliveryRoomsId;
    int childbirthDoctorId;
    boolean isAvailable;

    public DeliveryRooms() {
    }

    public DeliveryRooms(int deliveryRoomsId, int childbirthDoctorId, boolean isAvailable) {
        this.deliveryRoomsId = deliveryRoomsId;
        this.childbirthDoctorId = childbirthDoctorId;
        this.isAvailable = isAvailable;
    }

    public int getDeliveryRoomsId() {
        return deliveryRoomsId;
    }

    public void setDeliveryRoomsId(int deliveryRoomsId) {
        this.deliveryRoomsId = deliveryRoomsId;
    }

    public int getChildbirthDoctorId() {
        return childbirthDoctorId;
    }

    public void setChildbirthDoctorId(int childbirthDoctorId) {
        this.childbirthDoctorId = childbirthDoctorId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
