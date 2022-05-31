package com.solvd.hospital.DAO.impl;

import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.bin.Nurses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NursesDAO implements com.solvd.hospital.DAO.INursesDAO {

    private String  INSERT = "INSERT INTO Nurses(nursesId, firstName, lastName, chirophaneRoomId) VALUES (?,?,?,?) ";
    private String  UPDATE = "UPDATE Nurses SET nursesId = ?, firstName = ?, lastName = ?, chirophaneRoomId = ? WHERE nursesId = ?)";
    private String DELETE = "DELETE FROM Nurses where nursesId = ?";
    private String GETALL = "SELECT nursesId, firstName, lastName, chirophaneRoomId FROM Nurses";
    private String GETONE = "SELECT nursesId, firstName, lastName, chirophaneRoomId FROM Nurses WHERE nursesId = ?";

    private Connection conn;

    public NursesDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Nurses a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1,a.getNursesId());
            stat.setString(2,a.getFirstName());
            stat.setString(3,a.getLastName());
            stat.setInt(4,a.getChirophaneRoomId());
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
    public void update(Nurses a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1,a.getNursesId());
            stat.setString(2,a.getFirstName());
            stat.setString(3,a.getLastName());
            stat.setInt(4,a.getChirophaneRoomId());
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
    public void delete(Nurses a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1,a.getNursesId());

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

    private Nurses convert (ResultSet rs) throws SQLException {
        int nursesId = rs.getInt("nursesId");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        int chirophaneRoomId = rs.getInt("chirophaneRoomId");
        Nurses nurse = new Nurses(nursesId,firstName,lastName,chirophaneRoomId);
        return nurse;
    }

    @Override
    public List<Nurses> getList() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Nurses> nursesList = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                nursesList.add(convert(rs));
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
        } return nursesList;
    }

    @Override
    public Nurses getObject(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Nurses a = null;
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
