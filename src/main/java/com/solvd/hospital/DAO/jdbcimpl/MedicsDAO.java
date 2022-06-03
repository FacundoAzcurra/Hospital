package com.solvd.hospital.DAO.jdbcimpl;

import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IMedicsDAO;
import com.solvd.hospital.domain.Medics;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicsDAO extends AbstractDAO implements IMedicsDAO {

    private final static String  INSERT = "INSERT INTO Medics(idMedics, firstName, lastName, roomId, doctorOfficeId) VALUES (?,?,?,?,?) ";
    private final static String  UPDATE = "UPDATE Medics SET idMedics = ?, firstName = ?, lastName = ?, roomId = ?, doctorOfficeId = ? WHERE idMedics = ?)";
    private final static String DELETE = "DELETE FROM Medics where idMedics = ?";
    private final static String GET_ALL = "SELECT idMedics, firstName, lastName, roomId, doctorOfficeId";
    private final static String GET_ONE = "SELECT idMedics, firstName, lastName, roomId, doctorOfficeId FROM Medics WHERE idMedics = ?";

    @Override
    public void insert(Medics a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1,a.getidMedics());
            stat.setString(2,a.getFirstName());
            stat.setString(2,a.getLastName());
            stat.setInt(4,a.getRoomId());
            stat.setInt(5,a.getDoctorOfficeId());

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
    public void update(Medics a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1,a.getidMedics());
            stat.setString(2,a.getFirstName());
            stat.setString(2,a.getLastName());
            stat.setInt(4,a.getRoomId());
            stat.setInt(5,a.getDoctorOfficeId());
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

    private Medics convert (ResultSet rs) throws SQLException {
        int idMedics = rs.getInt("idMedics");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        int roomId = rs.getInt("roomId");
        int doctorOfficeId = rs.getInt("doctorOfficeId");
        Medics medics = new Medics(idMedics,firstName,lastName,roomId,doctorOfficeId);
        return medics;
    }

    @Override
    public List<Medics> getList() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Medics> medicsList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                medicsList.add(convert(rs));
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
        } return medicsList;
    }

    @Override
    public Medics getObject(Integer id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Medics a = null;
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
