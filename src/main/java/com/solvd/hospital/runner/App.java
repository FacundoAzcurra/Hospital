package com.solvd.hospital.runner;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IRoomsDAO;
import com.solvd.hospital.DAO.jdbcimpl.RoomsDAO;
import com.solvd.hospital.domain.Rooms;
import com.solvd.hospital.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) throws DAOException,SQLException {

        LOG.info("Select a table to work in. \n1. Rooms  \n2. Appointments \n3. Medics \n4. Prescriptions \n5. Nurses ");
        Scanner scoption = new Scanner(System.in);
        int option;
        option = scoption.nextInt();

        switch (option) {
            case 1:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n4. Get all\n 5. Get one");
                Scanner scrooms = new Scanner(System.in);
                int roomsopt;
                roomsopt = scrooms.nextInt();
                switch (roomsopt) {
                    case 1:
                        try(Connection connection = ConnectionPool.getInstance().getConnection()){
                            IRoomsDAO room = new RoomsDAO(connection);
                            Rooms room5 = new Rooms(5,false,2,4,5);
                            room.insert(room5);
                            LOG.info("Room inserted.");
                        } catch (ConnectException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:

                        break;
                    case 3:
                        break;
                    case 4:
                        LOG.info("Getting all rooms objects...");
                    try (Connection connection = ConnectionPool.getInstance().getConnection()) {
                        IRoomsDAO room = new RoomsDAO(connection);
                        List<Rooms> roomsList = room.getList();
                        for (Rooms u : roomsList) {
                            LOG.info(u.toString());
                        }
                        if (connection != null) {
                            LOG.info("You are inside");
                        } else {
                            LOG.info("Connection error.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ConnectException e) {
                        e.printStackTrace();
                    } finally {
                    }
                    break;
                    case 5:
                }
                break;
            case 2:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n4. Get all\n 5. Get one");
                break;
            case 3:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n4. Get all\n 5. Get one");
                break;
            case 4:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n4. Get all\n 5. Get one");
                break;
            case 5:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n4. Get all\n 5. Get one");
                break;
            default:
                LOG.info("Please select a valid option");
                break;
        }
    }
}




