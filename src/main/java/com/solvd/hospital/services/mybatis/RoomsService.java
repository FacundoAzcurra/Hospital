package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Rooms;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface RoomsService {
    Rooms getRooms(int idRooms);

    void saveRooms(Rooms rooms);

    void updateRoomById(int idRooms, Rooms newRoom);

    Rooms getRoomsById(int idRooms);

    void deleteRoom(Rooms idRooms);
}
