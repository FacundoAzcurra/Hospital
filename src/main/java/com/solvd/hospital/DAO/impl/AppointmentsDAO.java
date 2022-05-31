package com.solvd.hospital.DAO.impl;

import com.solvd.hospital.DAO.IAppointmentsDAO;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.bin.Appointments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsDAO implements IAppointmentsDAO {

    private String  INSERT = "INSERT INTO Appointments(appointmentID, medicId, appointmentRoomID, patientId) VALUES (?,?,?,?) ";
    private String  UPDATE = "UPDATE Appointments SET appointmentID = ?, medicId = ?, appointmentRoomID = ?, patientId = ? WHERE appointmentID = ?)";
    private String DELETE = "DELETE FROM appointments where appointmentID = ?";
    private String GETALL = "SELECT appointmentID, medicId, appointmentRoomID, patientId FROM Appointments";
    private String GETONE = "SELECT appointmentID, medicId, appointmentRoomID, patientId FROM Appointments WHERE appointmentId = ?";

    private Connection conn;

    public AppointmentsDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Appointments a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1,a.getAppointmentID());
            stat.setInt(2,a.getMedicId());
            stat.setInt(3,a.getAppointmentRoomID());
            stat.setInt(4,a.getPatientId());
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
    public void update(Appointments a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1,a.getAppointmentID());
            stat.setInt(2,a.getMedicId());
            stat.setInt(3,a.getAppointmentRoomID());
            stat.setInt(4,a.getPatientId());
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
    public void delete(Appointments a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1,a.getAppointmentID());

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

    private Appointments convert (ResultSet rs) throws SQLException {
        int appointmentId = rs.getInt("appointmentId");
        int medicId = rs.getInt("medicId");
        int appointmentRoomId = rs.getInt("appointmentRoomId");
        int patientId = rs.getInt("patientId");
        Appointments appointment = new Appointments(appointmentId, medicId, appointmentRoomId, patientId);
        return appointment;
    }

    @Override
    public List<Appointments> getList() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Appointments> appointmentsList = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                appointmentsList.add(convert(rs));
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
        } return appointmentsList;
    }

    @Override
    public Appointments getObject(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Appointments a = null;
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