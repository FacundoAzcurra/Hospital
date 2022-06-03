package com.solvd.hospital.runner;
import com.solvd.hospital.DAO.*;
import com.solvd.hospital.DAO.jdbcimpl.*;
import com.solvd.hospital.bin.*;
import com.solvd.hospital.services.mybatis.servicesimpl.MedicsService;
import com.solvd.hospital.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) throws DAOException,SQLException {

        LOG.info("Select your desired connection method: ");
        LOG.info("1.JDBC");
        LOG.info("2.myBatis(Medics Service demonstration)");
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
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n 4. Get all\n 5. Get one");
                Scanner scrooms = new Scanner(System.in);
                int roomsopt;
                roomsopt = scrooms.nextInt();
                switch (roomsopt) {
                    case 1:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            IRoomsDAO room = new RoomsDAO();
                            Rooms room5 = new Rooms(6,false,3,4,5);
                            room.insert(room5);
                            LOG.info("Room inserted.");
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 2:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Updating room...");
                            IRoomsDAO room = new RoomsDAO();
                            Rooms room5 = new Rooms(5,false,2,4,5);
                            room.update(room5);
                            LOG.info("Room updated.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 3:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Deleting room...");
                            IRoomsDAO room = new RoomsDAO();
                            room.delete(2);
                            LOG.info("Deleted room.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
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
                            LOG.info("Closing connection...");
                        } else {
                            LOG.info("Connection error.");
                            LOG.info("Closing connection...");
                        }
                    } catch (SQLException e) {
                        LOG.error(e);
                    } catch (ConnectException e) {
                        LOG.error(e);
                    }finally {

                    }

                    break;
                    case 5:
                        LOG.info("Getting room...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IRoomsDAO room = new RoomsDAO();
                            LOG.info(room.getObject(1));
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        } break;
                        }

                break;
            case 2:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n 4. Get all\n 5. Get one");
                Scanner scappo = new Scanner(System.in);
                int appoopt;
                appoopt = scappo.nextInt();
                switch (appoopt) {
                    case 1:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
                            Appointments appointments1 = new Appointments(1,1,3,4);
                            appointmentsDAO.insert(appointments1);
                            LOG.info("Appointment inserted.");
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 2:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Updating appointment...");
                            IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
                            Appointments appointments1 = new Appointments(1,1,3,4);
                            appointmentsDAO.update(appointments1);
                            LOG.info("Appointment updated.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 3:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Deleting appointment...");
                            IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
                            appointmentsDAO.delete(5);
                            LOG.info("Deleted appointment.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 4:
                        LOG.info("Getting all appointments...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
                            List<Appointments> appointmentsList = appointmentsDAO.getList();
                            for (Appointments u : appointmentsList) {
                                LOG.info(u.toString());
                            }
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }finally {

                        }

                        break;
                    case 5:
                        LOG.info("Getting appointment...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
                            LOG.info(appointmentsDAO.getObject(1));
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        } break;
                }

                break;
            case 3:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n 4. Get all\n 5. Get one");
                Scanner scmedics = new Scanner(System.in);
                int medicsopt;
                medicsopt = scmedics.nextInt();
                switch (medicsopt) {
                    case 1:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            IMedicsDAO medicsDAO = new MedicsDAO();
                            Medics medics1 = new Medics(5,"Sacarepepo","Ronaldinho",5,5);
                            medicsDAO.insert(medics1);
                            LOG.info("Medic inserted.");
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 2:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Updating medic...");
                            IMedicsDAO medicsDAO = new MedicsDAO();
                            Medics medics1 = new Medics(1,"Sacarepepo","Ronaldinho",1,1);
                            medicsDAO.update(medics1);
                            LOG.info("Medic updated.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 3:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Deleting medic...");
                            IMedicsDAO medicsDAO = new MedicsDAO();
                            medicsDAO.delete(5);
                            LOG.info("Deleted medic.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 4:
                        LOG.info("Getting all medics...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IMedicsDAO medicsDAO = new MedicsDAO();
                            List<Medics> medicsList = medicsDAO.getList();
                            for (Medics u : medicsList) {
                                LOG.info(u.toString());
                            }
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }finally {

                        }

                        break;
                    case 5:
                        LOG.info("Getting medic...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IMedicsDAO medicsDAO = new MedicsDAO();
                            LOG.info(medicsDAO.getObject(1));
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        } break;
                }

                break;
            case 4:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n 4. Get all\n 5. Get one");
                Scanner scprescription = new Scanner(System.in);
                int prescriptionopt;
                prescriptionopt = scprescription.nextInt();
                switch (prescriptionopt) {
                    case 1:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
                            Prescription prescription = new Prescription(5,10,1,1);
                            prescriptionDAO.insert(prescription);
                            LOG.info("Prescription inserted.");
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 2:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Updating prescription...");
                            IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
                            Prescription prescription = new Prescription(5,10,1,1);
                            prescriptionDAO.update(prescription);
                            LOG.info("Prescription updated.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 3:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Deleting prescription...");
                            IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
                            prescriptionDAO.delete(5);
                            LOG.info("Deleted prescription.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 4:
                        LOG.info("Getting all prescriptions...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
                            List<Prescription> prescriptionList = prescriptionDAO.getList();
                            for (Prescription u : prescriptionList) {
                                LOG.info(u.toString());
                            }
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");

                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }finally {

                        }

                        break;
                    case 5:
                        LOG.info("Getting prescription...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
                            LOG.info(prescriptionDAO.getObject(1));
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");

                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        } break;
                }

                break;
            case 5:
                LOG.info("Select an option to do. \n 1. Insert\n 2. Update\n 3. Delete \n 4. Get all\n 5. Get one");
                Scanner scnurses = new Scanner(System.in);
                int nursesopt;
                nursesopt = scnurses.nextInt();
                switch (nursesopt) {
                    case 1:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            INursesDAO nursesDAO = new NursesDAO();
                            Nurses nurses = new Nurses(5,"Maria","Benzina",2);
                            nursesDAO.insert(nurses);
                            LOG.info("Nurse inserted.");
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 2:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Updating nurse...");
                            INursesDAO nursesDAO = new NursesDAO();
                            Nurses nurses = new Nurses(5,"Maria","surname2",2);
                            nursesDAO.update(nurses);
                            LOG.info("Nurse updated.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 3:
                        try(Connection conn = ConnectionPool.getInstance().getConnection()){
                            LOG.info("Deleting nurse...");
                            INursesDAO nursesDAO = new NursesDAO();
                            nursesDAO.delete(5);
                            LOG.info("Deleted nurse.");
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }
                        break;
                    case 4:
                        LOG.info("Getting all nurses...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            INursesDAO nursesDAO = new NursesDAO();
                            List<Nurses> nursesList = nursesDAO.getList();
                            for (Nurses u : nursesList) {
                                LOG.info(u.toString());
                            }
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        }finally {

                        }

                        break;
                    case 5:
                        LOG.info("Getting nurse...");
                        try (Connection conn = ConnectionPool.getInstance().getConnection()) {
                            INursesDAO nursesDAO = new NursesDAO();
                            LOG.info(nursesDAO.getObject(1));
                            if (conn != null) {
                                LOG.info("You are inside");
                                LOG.info("Closing connection...");
                            } else {
                                LOG.info("Connection error.");
                                LOG.info("Closing connection...");
                            }
                        } catch (SQLException e) {
                            LOG.error(e);
                        } catch (ConnectException e) {
                            LOG.error(e);
                        } break;
                }
                break;
            default:
                LOG.info("Please select a valid option");
                break;
        }
           break;
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
                break;

            default:
                LOG.info("Not valid option!");
                break;

        }
}
}




