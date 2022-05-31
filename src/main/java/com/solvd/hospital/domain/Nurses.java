package com.solvd.hospital.domain;

public class Nurses {
    int nursesId;
    String firstName;
    String lastName;
    int chirophaneRoomId;

    public Nurses() {
    }

    public Nurses(int nursesId, String firstName, String lastName, int chirophaneRoomId) {
        this.nursesId = nursesId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.chirophaneRoomId = chirophaneRoomId;
    }

    public int getNursesId() {
        return nursesId;
    }

    public void setNursesId(int nursesId) {
        this.nursesId = nursesId;
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

    public int getChirophaneRoomId() {
        return chirophaneRoomId;
    }

    public void setChirophaneRoomId(int chirophaneRoomId) {
        this.chirophaneRoomId = chirophaneRoomId;
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
        return "Nurses{" +
                "nursesId=" + nursesId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", chirophaneRoomId=" + chirophaneRoomId +
                '}';
    }
}
