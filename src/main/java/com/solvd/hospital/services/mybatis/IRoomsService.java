package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Appointments;
import com.solvd.hospital.domain.Rooms;

import java.util.List;

public interface IRoomsService {
    List<Rooms> getRooms();

    void saveRooms(Rooms rooms);

    void updateRoomById(int idRooms, Rooms newRoom);

    Rooms getRoomsById(int idRooms);

    void deleteRoom(int idRooms);
}
