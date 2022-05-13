package com.solvd.hospital.model;

public class DoctorOffice {
    int doctorOfficeId;

    public DoctorOffice() {
    }

    public DoctorOffice(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }

    public int getDoctorOfficeId() {
        return doctorOfficeId;
    }

    public void setDoctorOfficeId(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
