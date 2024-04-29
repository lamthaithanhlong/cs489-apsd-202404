package edu.miu.ent.service;

import edu.miu.ent.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment addNewAppointment(Appointment newAppointment);
    Appointment getAppointmentById(Integer appointmentId);
    Appointment updateAppointment(Appointment editedAppointment);
    List<Appointment> getAppointmentsByStatus(String status);

    boolean deleteAppointment(Integer id);
}