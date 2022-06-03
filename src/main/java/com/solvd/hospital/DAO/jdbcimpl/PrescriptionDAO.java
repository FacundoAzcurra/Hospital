package com.solvd.hospital.DAO.jdbcimpl;

import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IPrescriptionDAO;
import com.solvd.hospital.bin.Prescription;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO extends AbstractDAO implements IPrescriptionDAO {

    private final static String  INSERT = "INSERT INTO Prescription(idPrescription, prescriptionPrice, medicId, patientId) VALUES (?,?,?,?) ";
    private final static String  UPDATE = "UPDATE Prescription SET prescriptionPrice = ?, medicId = ?, patientId = ? WHERE idPrescription = ?";
    private final static String DELETE = "DELETE FROM Prescription where idPrescription = ?";
    private final static String GET_ALL = "SELECT idPrescription, prescriptionPrice, medicId, patientId FROM Prescription";
    private final static String GET_ONE = "SELECT idPrescription, prescriptionPrice, medicId, patientId FROM Prescription WHERE idPrescription = ?";


    @Override
    public void insert(Prescription a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1,a.getPrescriptionID());
            stat.setDouble(2,a.getPrescriptionPrice());
            stat.setInt(3,a.getMedicId());
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
    public void update(Prescription a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setDouble(1,a.getPrescriptionPrice());
            stat.setInt(2,a.getMedicId());
            stat.setInt(3,a.getPatientId());
            stat.setInt(4,a.getPrescriptionID());
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

    private Prescription convert (ResultSet rs) throws SQLException {
        int prescriptionID = rs.getInt("idPrescription");
        double prescriptionPrice = rs.getDouble("prescriptionPrice");
        int medicId = rs.getInt("medicId");
        int patientId = rs.getInt("patientId");
        Prescription prescription = new Prescription(prescriptionID,prescriptionPrice,medicId,patientId);
        return prescription;
    }

    @Override
    public List<Prescription> getList() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Prescription> prescriptionList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                prescriptionList.add(convert(rs));
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
        } return prescriptionList;
    }

    @Override
    public Prescription getObject(Integer id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Prescription a = null;
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
