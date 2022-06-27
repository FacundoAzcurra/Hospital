package com.solvd.hospital.services.jdbc;

import com.solvd.hospital.DAO.IAppointmentsDAO;
import com.solvd.hospital.DAO.impl.AppointmentsDAO;
import com.solvd.hospital.bin.Appointments;
import com.solvd.hospital.services.mybatis.IAppointmentsService;

import java.net.ConnectException;
import java.util.List;

public class AppointmentsService implements IAppointmentsService {

    @Override
    public List<Appointments> getAppointments() throws ConnectException {
        IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
        return appointmentsDAO.getList();
    }

    @Override
    public void saveAppointments(Appointments appointments) throws ConnectException {
        IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
        appointmentsDAO.insert(appointments);
    }

    @Override
    public void updateAppointmentById(int appointmentID, Appointments newAppointment) throws ConnectException {
        IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
         appointmentsDAO.update(newAppointment);
    }

    @Override
    public Appointments getAppointmentById(int appointmentID) throws ConnectException {
    IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
        return appointmentsDAO.getObject(appointmentID);
    }
    @Override
    public void deleteAppointment(int appointmentID) throws ConnectException {
        IAppointmentsDAO appointmentsDAO = new AppointmentsDAO();
        appointmentsDAO.delete(appointmentID);
    }
}
