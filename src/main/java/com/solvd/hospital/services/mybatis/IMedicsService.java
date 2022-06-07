package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Medics;

import java.net.ConnectException;
import java.util.List;


public interface IMedicsService {
    List<Medics> getMedics() throws ConnectException;

    void saveMedic(Medics medics) throws ConnectException;

    void updateMedicById(int idMedics, Medics newMedic) throws ConnectException;

    Medics getMedicById(int idMedics) throws ConnectException;

    void deleteMedic(int idMedics) throws ConnectException;
}
