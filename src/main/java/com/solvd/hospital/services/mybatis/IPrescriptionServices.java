package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Prescription;

import java.net.ConnectException;
import java.util.List;

public interface IPrescriptionServices {
    List<Prescription> getPrescription() throws ConnectException;

    void savePrescription(Prescription Prescription) throws ConnectException;

    void updatePrescriptionById(int idPrescription, Prescription newPrescription) throws ConnectException;

    Prescription getPrescriptionById(int PrescriptionID) throws ConnectException;

    void deletePrescription(int PrescriptionID) throws ConnectException;
}
