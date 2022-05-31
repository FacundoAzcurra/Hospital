package com.solvd.hospital.DAO.impl;

import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IPrescriptionDAO;
import com.solvd.hospital.bin.Appointments;
import com.solvd.hospital.bin.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO implements IPrescriptionDAO {

    private String  INSERT = "INSERT INTO Prescription(prescriptionID, prescriptionPrice, medicId, patientId) VALUES (?,?,?,?) ";
    private String  UPDATE = "UPDATE Prescription SET prescriptionID = ?, prescriptionPrice = ?, medicId = ?, patientId = ? WHERE prescriptionID = ?)";
    private String DELETE = "DELETE FROM Prescription where prescriptionID = ?";
    private String GETALL = "SELECT prescriptionID, prescriptionPrice, medicId, patientId";
    private String GETONE = "SELECT prescriptionID, prescriptionPrice, medicId, patientId FROM Prescription WHERE prescriptionID = ?";

    private Connection conn;

    public PrescriptionDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Prescription a) throws DAOException {
        PreparedStatement stat = null;
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
    public void update(Prescription a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
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
    public void delete(Prescription a) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1,a.getPrescriptionID());

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

    private Prescription convert (ResultSet rs) throws SQLException {
        int prescriptionID = rs.getInt("appointmentId");
        double prescriptionPrice = rs.getDouble("prescriptionPrice");
        int medicId = rs.getInt("medicId");
        int patientId = rs.getInt("patientId");
        Prescription prescription = new Prescription();
        return prescription;
    }

    @Override
    public List<Prescription> getList() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Prescription> prescriptionList = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                prescriptionList.add(convert(rs));
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
        } return prescriptionList;
    }

    @Override
    public Prescription getObject(Integer id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Prescription a = null;
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
