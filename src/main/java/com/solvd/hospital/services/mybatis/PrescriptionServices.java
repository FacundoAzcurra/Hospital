package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Prescription;

public interface PrescriptionServices {
    Prescription getPrescription(int PrescriptionID);

    void savePrescription(Prescription Prescription);

    void updatePrescriptionById(int idPrescription, Prescription newPrescription);

    Prescription getPrescriptionById(int PrescriptionID);

    void deletePrescription(Prescription PrescriptionID);
}
