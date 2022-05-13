package com.solvd.hospital.model;

public class MedicTrainees {
    int medicTraineeId;
    String firstName;
    String lastName;

    public MedicTrainees() {
    }

    public MedicTrainees(int medicTraineeId, String firstName, String lastName) {
        this.medicTraineeId = medicTraineeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getMedicTraineeId() {
        return medicTraineeId;
    }

    public void setMedicTraineeId(int medicTraineeId) {
        this.medicTraineeId = medicTraineeId;
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
}
