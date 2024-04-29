package edu.miu.ent.service.impl;

import edu.miu.ent.model.Appointment;
import edu.miu.ent.repository.AppointmentRepository;
import edu.miu.ent.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment addNewAppointment(Appointment newAppointment) {
        return appointmentRepository.save(newAppointment);
    }

    @Override
    public Appointment getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public Appointment updateAppointment(Appointment editedAppointment) {
        return appointmentRepository.save(editedAppointment);
    }



    @Override
    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    @Override
    public boolean deleteAppointment(Integer id) {
        if (appointmentRepository.existsById(id)){
            appointmentRepository.deleteById(id);
            return true;
        }else {
            return false;
        }



    }
}