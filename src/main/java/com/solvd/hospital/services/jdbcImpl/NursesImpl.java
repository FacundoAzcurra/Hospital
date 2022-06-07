package com.solvd.hospital.services.jdbcImpl;

import com.solvd.hospital.DAO.INursesDAO;
import com.solvd.hospital.DAO.impl.NursesDAO;
import com.solvd.hospital.bin.Nurses;
import com.solvd.hospital.services.mybatis.INursesService;

import java.net.ConnectException;
import java.util.List;

public class NursesImpl implements INursesService {

    @Override
    public List<Nurses> getNurses() throws ConnectException {
        INursesDAO nursesDAO = new NursesDAO();
        return nursesDAO.getList();
    }

    @Override
    public void saveNurse(Nurses nurses) throws ConnectException {
        INursesDAO nursesDAO = new NursesDAO();
        nursesDAO.insert(nurses);
    }

    @Override
    public void updateNurseById(int idNurses, Nurses newNurse) throws ConnectException {
        INursesDAO nursesDAO = new NursesDAO();
        nursesDAO.update(newNurse);
    }

    @Override
    public Nurses getNurseById(int nursesId) throws ConnectException {
        INursesDAO nursesDAO = new NursesDAO();
        return nursesDAO.getObject(nursesId);
    }

    @Override
    public void deleteNurse(int nursesId) throws ConnectException {
        INursesDAO nursesDAO = new NursesDAO();
        nursesDAO.delete(nursesId);
    }
}
