package com.solvd.hospital.DAO.impl;

import com.solvd.hospital.DAO.DAO;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.RoomsDAO;
import com.solvd.hospital.bin.Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IRoomsDAO implements RoomsDAO {

    private String  INSERT = "INSERT INTO Rooms(idRooms, isAvailable, floor, MedicId, DoctorOfficeId) VALUES (?,?,?,?,?) ";
    private String  UPDATE = "UPDATE Rooms SET isAvailable = ?, floor = ?, MedicId = ?, DoctorOfficeId = ? WHERE idRooms = ?)";
    private String DELETE = "DELETE FROM Rooms where idRooms = ?";
    private String GETALL = "SELECT idRooms, isAvailable, floor, MedicId, DoctorOfficeId FROM Rooms";
    private String GETONE = "SELECT idRooms, isAvailable, floor, MedicId, DoctorOfficeId FROM Rooms WHERE idRooms = ?";

    private Connection conn;

    public IRoomsDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Rooms a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1,a.getRoomId());
            stat.setBoolean(2,a.isAvailable());
            stat.setInt(3,a.getFloor());
            stat.setInt(4,a.getMedicId());
            stat.setInt(5,a.getDoctorOfficeId());
            if(stat.executeUpdate() == 0 ){
               throw new DAOException("It may not have saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR",e);
        } finally {
            if (stat != null){
                try{
                    stat.close();
                } catch (SQLException e){
                    throw new DAOException("SQL ERROR",e);
                }
            }
            
        }

    }

    @Override
    public void update(Rooms a) {

    }

    @Override
    public void delete(Rooms a) {

    }

    @Override
    public List<Rooms> getRooms() {
        return null;
    }

    @Override
    public Rooms getRoom(Integer id) {
        return null;
    }
}
