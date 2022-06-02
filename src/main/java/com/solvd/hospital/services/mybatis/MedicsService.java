package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Medics;
import com.solvd.hospital.domain.Rooms;


public interface MedicsService {
    Medics getMedics(int idMedics);

    void saveMedic(Medics medics);

    void updateMedicById(int idMedics, Medics newMedic);

    Medics getMedicById(int idMedics);

    void deleteMedic(Medics idMedics);
}
