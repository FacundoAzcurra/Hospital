package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Rooms;

import java.net.ConnectException;
import java.util.List;

public interface IRoomsService {
    List<Rooms> getRooms() throws ConnectException;

    void saveRooms(Rooms rooms) throws ConnectException;

    void updateRoomById(int idRooms, Rooms newRoom) throws ConnectException;

    Rooms getRoomsById(int idRooms) throws ConnectException;

    void deleteRoom(int idRooms) throws ConnectException;
}
