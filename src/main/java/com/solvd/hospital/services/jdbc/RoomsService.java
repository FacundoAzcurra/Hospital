package com.solvd.hospital.services.jdbc;

import com.solvd.hospital.DAO.IRoomsDAO;
import com.solvd.hospital.DAO.impl.RoomsDAO;
import com.solvd.hospital.bin.Rooms;
import com.solvd.hospital.services.mybatis.IRoomsService;

import java.net.ConnectException;
import java.util.List;

public class RoomsService implements IRoomsService {

    @Override
    public List<Rooms> getRooms() throws ConnectException {
        IRoomsDAO roomDAO = new RoomsDAO();
        return roomDAO.getList();
    }

    @Override
    public void saveRooms(Rooms rooms) throws ConnectException {
        IRoomsDAO roomDAO = new RoomsDAO();
        roomDAO.insert(rooms);
    }

    @Override
    public void updateRoomById(int idRooms, Rooms newRoom) throws ConnectException {
        IRoomsDAO roomDAO = new RoomsDAO();
        roomDAO.update(newRoom);
    }

    @Override
    public Rooms getRoomsById(int idRooms) throws ConnectException {
        IRoomsDAO roomDAO = new RoomsDAO();
        return roomDAO.getObject(idRooms);
    }

    @Override
    public void deleteRoom(int idRooms) throws ConnectException {
        IRoomsDAO roomDAO = new RoomsDAO();
        roomDAO.delete(idRooms);
    }
}
