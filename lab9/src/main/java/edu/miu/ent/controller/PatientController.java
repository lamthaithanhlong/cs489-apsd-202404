package edu.miu.ent.controller;

import edu.miu.ent.model.Appointment;
import edu.miu.ent.model.User;
import edu.miu.ent.service.AddressService;
import edu.miu.ent.service.AppointmentService;
import edu.miu.ent.service.UserService;
import edu.miu.ent.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.API_VERSION+"/patents")
public class PatientController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping("/patient/register")
    public User registerPatient(@RequestBody User patient) {
        return userService.savePatient(patient);
    }



    @PostMapping("/appointment/new")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addNewAppointment(appointment);
    }
}