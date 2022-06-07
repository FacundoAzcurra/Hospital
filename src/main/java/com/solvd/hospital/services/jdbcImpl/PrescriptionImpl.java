package com.solvd.hospital.services.jdbcImpl;

import com.solvd.hospital.DAO.IPrescriptionDAO;
import com.solvd.hospital.DAO.impl.PrescriptionDAO;
import com.solvd.hospital.bin.Prescription;
import com.solvd.hospital.services.mybatis.IPrescriptionServices;

import java.net.ConnectException;
import java.util.List;

public class PrescriptionImpl implements IPrescriptionServices {
    @Override
    public List<Prescription> getPrescription() throws ConnectException {
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        return prescriptionDAO.getList();
    }

    @Override
    public void savePrescription(Prescription Prescription) throws ConnectException {
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        prescriptionDAO.insert(Prescription);

    }

    @Override
    public void updatePrescriptionById(int idPrescription, Prescription newPrescription) throws ConnectException {
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        prescriptionDAO.update(newPrescription);

    }

    @Override
    public Prescription getPrescriptionById(int PrescriptionID) throws ConnectException {
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        return prescriptionDAO.getObject(PrescriptionID);
    }

    @Override
    public void deletePrescription(int PrescriptionID) throws ConnectException {
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        prescriptionDAO.delete(PrescriptionID);
    }
}

