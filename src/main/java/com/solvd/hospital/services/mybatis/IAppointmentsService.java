package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Appointments;

import java.net.ConnectException;
import java.util.List;

public interface IAppointmentsService {
    List<Appointments> getAppointments() throws ConnectException;

    void saveAppointments(Appointments appointments) throws ConnectException;

    void updateAppointmentById(int appointmentID, Appointments newAppointment) throws ConnectException;

    Appointments getAppointmentById(int appointmentID) throws ConnectException;

    void deleteAppointment(int appointmentID) throws ConnectException;
}
