package com.solvd.hospital;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.RoomsDAO;
import com.solvd.hospital.DAO.impl.IRoomsDAO;
import com.solvd.hospital.bin.Rooms;
import com.solvd.hospital.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) throws DAOException,SQLException {

        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            RoomsDAO room = new IRoomsDAO(connection);
            List<Rooms> roomsList = room.getRooms();
            for(Rooms u : roomsList){
                LOG.info(u.toString());
            }
            if (connection != null){
                LOG.info("You are inside");
            }else{
                LOG.info("Connection error.");
            }

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ConnectException e) {
            e.printStackTrace();
        } finally {
        }
    }
}




