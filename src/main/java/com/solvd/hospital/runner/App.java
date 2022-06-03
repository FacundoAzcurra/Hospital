package com.solvd.hospital.runner;
import com.solvd.hospital.DAO.DAOException;
import com.solvd.hospital.DAO.IRoomsDAO;
import com.solvd.hospital.DAO.jdbcimpl.RoomsDAO;
import com.solvd.hospital.domain.Medics;
import com.solvd.hospital.domain.Rooms;
import com.solvd.hospital.services.mybatis.servicesimpl.MedicsService;
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

        LOG.info("1.JDBC\n2.myBatis");
        Scanner scoptiondriver = new Scanner(System.in);
        int optiondriver;
        optiondriver = scoptiondriver.nextInt();
        switch (optiondriver){
            case 1:
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
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            IRoomsDAO room = new RoomsDAO();
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
                    try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                        IRoomsDAO room = new RoomsDAO();
                        List<Rooms> roomsList = room.getList();
                        for (Rooms u : roomsList) {
                            LOG.info(u.toString());
                        }
                        if (conn != null) {
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
            case 2:
                //myBatis every service working.(Medics Service example)
                MedicsService ms = new MedicsService();
                List<Medics> medics = ms.getMedics();
                medics.stream().forEach(medic -> LOG.info(medic));
                LOG.info("------------------------------------");
                ms.saveMedic(new Medics(5,"Nico","ThaiProfessor",4,4));
                medics = ms.getMedics();
                medics.stream().forEach(medic -> LOG.info(medic));
                LOG.info("------------------------------------");
                ms.updateMedicById(5,new Medics(5,"Pani","Strange",4,4));
                medics = ms.getMedics();
                medics.stream().forEach(medic -> LOG.info(medic));
                LOG.info("------------------------------------");
                ms.deleteMedic(5);
                medics = ms.getMedics();
                medics.stream().forEach(medic -> LOG.info(medic));
                LOG.info("------------------------------------");
        }
}
}




