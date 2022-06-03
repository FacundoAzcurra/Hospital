package com.solvd.hospital.DAO.jdbcimpl;

import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.bin.Nurses;
import com.solvd.hospital.DAO.INursesDAO;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NursesDAO extends AbstractDAO implements INursesDAO {

    private final static String  INSERT = "INSERT INTO Nurses(idNurses, firstName, lastName, chirophaneRoomId) VALUES (?,?,?,?) ";
    private final static String  UPDATE = "UPDATE Nurses SET firstName = ?, lastName = ?, chirophaneRoomId = ? WHERE idNurses = ?";
    private final static String DELETE = "DELETE FROM Nurses where idNurses = ?";
    private final static String GET_ALL = "SELECT idNurses, firstName, lastName, chirophaneRoomId FROM Nurses";
    private final static String GET_ONE = "SELECT idNurses, firstName, lastName, chirophaneRoomId FROM Nurses WHERE idNurses = ?";

    @Override
    public void insert(Nurses a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
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
    public void update(Nurses a) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(UPDATE);

            stat.setString(1,a.getFirstName());
            stat.setString(2,a.getLastName());
            stat.setInt(3,a.getChirophaneRoomId());
            stat.setInt(4,a.getNursesId());
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

    private Nurses convert (ResultSet rs) throws SQLException {
        int nursesId = rs.getInt("idNurses");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        int chirophaneRoomId = rs.getInt("chirophaneRoomId");
        Nurses nurse = new Nurses(nursesId,firstName,lastName,chirophaneRoomId);
        return nurse;
    }

    @Override
    public List<Nurses> getList() throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Nurses> nursesList = new ArrayList<>();
        Connection conn = getConnection();
        try{
            stat = conn.prepareStatement(GET_ALL);
            rs = stat.executeQuery();
            while(rs.next()) {
                nursesList.add(convert(rs));
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
        } return nursesList;
    }

    @Override
    public Nurses getObject(Integer id) throws DAOException, ConnectException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Nurses a = null;
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
