package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Nurses;

import java.util.List;

public interface INursesService {
    List<Nurses> getNurses();

    void saveNurse(Nurses nurses);

    void updateNurseById(int idNurses, Nurses newNurse);

    Nurses getNurseById(int nursesId);

    void deleteNurse(int nursesId);
}
