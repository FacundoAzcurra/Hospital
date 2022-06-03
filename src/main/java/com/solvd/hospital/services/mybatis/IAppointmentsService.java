package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.bin.Appointments;

import java.util.List;

public interface IAppointmentsService {
    List<Appointments> getAppointments();

    void saveAppointments(Appointments appointments);

    void updateAppointmentById(int appointmentID, Appointments newAppointment);

    Appointments getAppointmentById(int appointmentID);

    void deleteAppointment(int appointmentID);
}
