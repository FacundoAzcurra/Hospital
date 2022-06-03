package com.solvd.hospital.DAO.jdbcimpl;

import com.solvd.hospital.DAO.IAppointmentsDAO;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.domain.Appointments;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentsDAO extends AbstractDAO implements IAppointmentsDAO {

    private final static String INSERT = "INSERT INTO Appointments(appointmentID, medicId, appointmentRoomID, patientId) VALUES (?,?,?,?) ";
    private final static String UPDATE = "UPDATE Appointments SET appointmentID = ?, medicId = ?, appointmentRoomID = ?, patientId = ? WHERE appointmentID = ?)";
    private final static String DELETE = "DELETE FROM appointments where appointmentID = ?";
    private final static String GET_ALL = "SELECT appointmentID, medicId, appointmentRoomID, patientId FROM Appointments";
    private final static String GET_ONE = "SELECT appointmentID, medicId, appointmentRoomID, patientId FROM Appointments WHERE appointmentId = ?";

    @Override
    public void insert(Appointments a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
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
            returnConnection(conn);
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
    public void update(Appointments a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
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
            returnConnection(conn);
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
    public void delete(int a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1,a);

            if(stat.executeUpdate() == 0 ){
                throw new DAOException("It may not have saved");
            }

        } catch (SQLException e) {
            throw new DAOException("SQL ERROR",e);
        } finally {
            returnConnection(conn);
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
    public List<Appointments> getList() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Appointments> appointmentsList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                appointmentsList.add(convert(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("SQL Error.",e);
        } finally {
            returnConnection(conn);
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
    public Appointments getObject(Integer id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Appointments a = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(GET_ONE);
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
            returnConnection(conn);
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
