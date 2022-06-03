package com.solvd.hospital.DAO.jdbcimpl;

import com.solvd.hospital.util.ConnectionPool;

import java.net.ConnectException;
import java.sql.Connection;

public  class AbstractDAO {

    public Connection getConnection() throws ConnectException {
        return ConnectionPool.getInstance().getConnection();
    }


    public void returnConnection(Connection connection){
        ConnectionPool.getInstance().returnConnection(connection);
    }

}
