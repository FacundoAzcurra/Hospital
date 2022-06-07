package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Nurses;

import java.net.ConnectException;
import java.util.List;

public interface INursesService {
    List<Nurses> getNurses() throws ConnectException;

    void saveNurse(Nurses nurses) throws ConnectException;

    void updateNurseById(int idNurses, Nurses newNurse) throws ConnectException;

    Nurses getNurseById(int nursesId) throws ConnectException;

    void deleteNurse(int nursesId) throws ConnectException;
}
