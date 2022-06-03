package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Medics;

import java.util.List;


public interface IMedicsService {
    List<Medics> getMedics();

    void saveMedic(Medics medics);

    void updateMedicById(int idMedics, Medics newMedic);

    Medics getMedicById(int idMedics);

    void deleteMedic(int idMedics);
}
