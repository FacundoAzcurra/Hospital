package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Nurses;

public interface NursesService {
    Nurses getNurses(int nursesId);

    void saveNurse(Nurses nurses);

    void updateNurseById(int idNurses, Nurses newNurse);

    Nurses getNurseById(int nursesId);

    void deleteNurse(Nurses nursesId);
}
