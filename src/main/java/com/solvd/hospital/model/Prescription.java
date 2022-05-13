package com.solvd.hospital.model;

public class Prescription {
    int prescriptionID;
    double prescriptionPrice;
    int medicId;
    int patientId;

    public Prescription() {
    }

    public Prescription(int prescriptionID, double prescriptionPrice, int medicId, int patientId) {
        this.prescriptionID = prescriptionID;
        this.prescriptionPrice = prescriptionPrice;
        this.medicId = medicId;
        this.patientId = patientId;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public double getPrescriptionPrice() {
        return prescriptionPrice;
    }

    public void setPrescriptionPrice(double prescriptionPrice) {
        this.prescriptionPrice = prescriptionPrice;
    }

    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
