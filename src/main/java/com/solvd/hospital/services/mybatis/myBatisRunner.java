package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Medics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class myBatisRunner {
    private final static Logger log = LogManager.getLogger(myBatisRunner.class);
    public static void main(String[] args) {

        //AppointmentsService appointmentsService = new AppointmentsService();
        //List<Appointments> appointments = appointmentsService.getAppointments();
        //log.info(appointments.get(0).getAppointmentID());
        //Appointments testA = appointmentsService.getAppointmentById(2);
        //log.info(testA);
        //appointmentsService.saveAppointments(new Appointments(2,2,2,2));
        //appointmentsService.deleteAppointment(1);

        /*NursesService nursesService = new NursesService();
        List<Nurses> nurses = nursesService.getNurses();
        nursesService.updateNurseById(18,new Nurses(1,"esquizo","akaka",2));
        nursesService.deleteNurse(66);
        log.info(nurses.get(0));NursesService
        nursesService.saveNurse(new Nurses(1,"nico","jaja XD",8));
*/
        MedicsService ms = new MedicsService();
        List<Medics> medics = ms.getMedics();
        medics.stream().forEach(medic -> log.info(medic));
        log.info("------------------------------------");
        ms.saveMedic(new Medics(5,"Nico","ThaiProfessor",4,4));
        medics = ms.getMedics();
        medics.stream().forEach(medic -> log.info(medic));
        log.info("------------------------------------");
        ms.updateMedicById(5,new Medics(5,"Pani","Strange",4,4));
        medics = ms.getMedics();
        medics.stream().forEach(medic -> log.info(medic));
        log.info("------------------------------------");
        ms.deleteMedic(5);
        medics = ms.getMedics();
        medics.stream().forEach(medic -> log.info(medic));
        log.info("------------------------------------");
    }
    }