package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Appointments;
import com.solvd.hospital.domain.Prescription;

import java.util.List;

public interface IPrescriptionServices {
    List<Prescription> getPrescription();

    void savePrescription(Prescription Prescription);

    void updatePrescriptionById(int idPrescription, Prescription newPrescription);

    Prescription getPrescriptionById(int PrescriptionID);

    void deletePrescription(int PrescriptionID);
}