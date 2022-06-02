package com.solvd.hospital.services.mybatis;

import com.solvd.hospital.domain.Appointments;
import com.solvd.hospital.domain.Rooms;

public interface AppointmentsService {
    Appointments getAppointments(int appointmentID);

    void saveAppointments(Appointments appointments);

    void updateAppointmentById(int appointmentID, Appointments newAppointment);

    Rooms getAppointmentById(int appointmentID);

    void deleteAppointment(Appointments appointmentID);
}
