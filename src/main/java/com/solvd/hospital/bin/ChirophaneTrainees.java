package com.solvd.hospital.bin;

public class ChirophaneTrainees {
    int chirophaneTraineeId;
    String firstName;
    String lastName;
    int chirophaneId;

    public ChirophaneTrainees() {
    }

    public ChirophaneTrainees(int chirophaneTraineeId, String firstName, String lastName, int chirophaneId) {
        this.chirophaneTraineeId = chirophaneTraineeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.chirophaneId = chirophaneId;
    }

    public int getChirophaneTraineeId() {
        return chirophaneTraineeId;
    }

    public void setChirophaneTraineeId(int chirophaneTraineeId) {
        this.chirophaneTraineeId = chirophaneTraineeId;
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

    public int getChirophaneId() {
        return chirophaneId;
    }

    public void setChirophaneId(int chirophaneId) {
        this.chirophaneId = chirophaneId;
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
        return "ChirophaneTrainees{" +
                "chirophaneTraineeId=" + chirophaneTraineeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", chirophaneId=" + chirophaneId +
                '}';
    }
}
