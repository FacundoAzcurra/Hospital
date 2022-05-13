package com.solvd.hospital.DAO;

import com.solvd.hospital.binary.Rooms;

import java.util.List;

public interface RoomsDAO {
    public List<Rooms> getAllRoom();
    public Rooms getRoomId(int id);
    public void updateRoom(Rooms rooms);
    public void deleteRoom(Rooms rooms);

}
