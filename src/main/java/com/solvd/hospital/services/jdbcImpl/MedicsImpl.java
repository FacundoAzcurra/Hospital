package com.solvd.hospital.services.jdbcImpl;

import com.solvd.hospital.DAO.IMedicsDAO;
import com.solvd.hospital.DAO.impl.MedicsDAO;
import com.solvd.hospital.bin.Medics;
import com.solvd.hospital.services.mybatis.IMedicsService;

import java.net.ConnectException;
import java.util.List;

public class MedicsImpl implements IMedicsService {

    @Override
    public List<Medics> getMedics() throws ConnectException {
        IMedicsDAO medicsDAO = new MedicsDAO();
        return medicsDAO.getList();
    }

    @Override
    public void saveMedic(Medics medics) throws ConnectException {
        IMedicsDAO medicsDAO = new MedicsDAO();
        medicsDAO.insert(medics);

    }

    @Override
    public void updateMedicById(int idMedics, Medics newMedic) throws ConnectException {
        IMedicsDAO medicsDAO = new MedicsDAO();
        medicsDAO.update(newMedic);

    }

    @Override
    public Medics getMedicById(int idMedics) throws ConnectException {
        IMedicsDAO medicsDAO = new MedicsDAO();
        return medicsDAO.getObject(idMedics);
    }

    @Override
    public void deleteMedic(int idMedics) throws ConnectException {
        IMedicsDAO medicsDAO = new MedicsDAO();
        medicsDAO.delete(idMedics);

    }
}
