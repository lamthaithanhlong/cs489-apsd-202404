package edu.miu.ent.controller;

import edu.miu.ent.model.Appointment;
import edu.miu.ent.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addNewAppointment(appointment);
    }


    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Integer id, @RequestBody Appointment appointment) {
        appointment.setAppointmentId(id);
        Appointment updatedAppointment = appointmentService.updateAppointment(appointment);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Integer id) {
        boolean deleted = appointmentService.deleteAppointment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}