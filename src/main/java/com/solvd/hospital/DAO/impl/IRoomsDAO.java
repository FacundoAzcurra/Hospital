package com.solvd.hospital.DAO.impl;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.solvd.hospital.DAO.DAO;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.RoomsDAO;
import com.solvd.hospital.bin.Rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void update(Rooms a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
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
    public void delete(Rooms a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1,a.getRoomId());

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

    private Rooms convert (ResultSet rs) throws SQLException {

        int roomId = rs.getInt("roomId");
        boolean isAvailable = rs.getBoolean("isAvailable");
        int floor = rs.getInt("floor");
        int medicId = rs.getInt("medicId");
        int doctorOfficeId = rs.getInt("doctorOfficeId");
        Rooms room = new Rooms(roomId, isAvailable, floor, medicId, doctorOfficeId);
        return room;
    }

    @Override
    public List<Rooms> getRooms() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Rooms> roomsList = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                roomsList.add(convert(rs));
            }
            } catch (SQLException e) {
            throw new DAOException("SQL Error.",e);
        } finally {
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    throw new DAOException("SQL Error.",e);
                }
            }
            if (stat != null){
                try {
                    stat.close();
                } catch (SQLException e){
                    throw new DAOException("SQL Error.",e);
                }
            }
        } return roomsList;

    }

    @Override
    public Rooms getRoom(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Rooms a = null;
        try{
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1,id);
            rs = stat.executeQuery();
            if (rs.next()) {
                a = convert(rs);

            } else {
                throw new DAOException("Register not found.");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL Error.",e);
        } finally {
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    throw new DAOException("SQL Error.",e);
                }
            }
            if (stat != null){
                try {
                    stat.close();
                } catch (SQLException e){
                    throw new DAOException("SQL Error.",e);
                }
            }
        } return a;
    }
}
