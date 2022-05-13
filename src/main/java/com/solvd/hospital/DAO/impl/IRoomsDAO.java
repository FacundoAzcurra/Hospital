package com.solvd.hospital.DAO.impl;

import com.solvd.hospital.model.Rooms;

import java.util.ArrayList;
import java.util.List;


public interface IRoomsDAO {
    List<Rooms> ROOMS;

    public IRoomsDAO(){
        ROOMS = new ArrayList<Rooms>();
        Rooms rooms1 = new Rooms(1,1,1,1);
        Rooms rooms2 = new Rooms(2,1,1,2);

        ROOMS.add(rooms1);
        ROOMS.add(rooms2);
    }

    @Override
    public void deleteRoom(Rooms rooms){
        ROOMS.remove(rooms.getRoomId());
        System.out.println("Room: ID"+ rooms.getRoomId()+", deleted from database");
    }

    @Override
    public List<Rooms> getRooms(){
        return getRooms();
    }

    @Override
    public Rooms getRoomId(){
        return ROOMS.get(getRoomId().getRoomId());
    }

    @Override
    public void updateRoom(Rooms rooms){
        ROOMS.get(rooms.getRoomId()).setFloor(rooms.getFloor());
        System.out.println("Room: id "+rooms.getRoomId()+", updated in the database");
    }
}

