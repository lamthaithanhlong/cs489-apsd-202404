package com.example.lab6;

import com.example.lab6.model.Appointment;
import com.example.lab6.model.Dentist;
import com.example.lab6.model.Patient;
import com.example.lab6.model.Surgery;
import com.example.lab6.service.AppointmentService;
import com.example.lab6.service.DentistService;
import com.example.lab6.service.PatientService;
import com.example.lab6.service.SurgeryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Lab6Application {
	private final PatientService patientService;
	private final DentistService dentistService;
	private final AppointmentService appointmentService;
	private final SurgeryService surgeryService;

	public Lab6Application(PatientService patientService,
					  DentistService dentistService,
					  AppointmentService appointmentService,
					  SurgeryService surgeryService) {
		this.appointmentService = appointmentService;
		this.dentistService = dentistService;
		this.surgeryService = surgeryService;
		this.patientService = patientService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab6Application.class, args);
	}

	@Bean
	public CommandLineRunner initData() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm");

		// Creating or retrieving surgeries
		Surgery s15 = surgeryService.saveSurgery("S15");
		Surgery s10 = surgeryService.saveSurgery("S10");
		Surgery s13 = surgeryService.saveSurgery("S13");

		// Creating or retrieving dentists
		Dentist tony = dentistService.findOrCreate("Tony Smith");
		Dentist helen = dentistService.findOrCreate("Helen Pearson");
		Dentist robin = dentistService.findOrCreate("Robin Plevin");

		// Creating or retrieving patients
		Patient gillian = patientService.findOrCreate("P100", "Gillian White");
		Patient jill = patientService.findOrCreate("P105", "Jill Bell");
		Patient ian = patientService.findOrCreate("P108", "Ian MacKay");
		Patient john = patientService.findOrCreate("P110", "John Walker");

		// Creating and saving appointments
		appointmentService.createOrUpdate(new Appointment(LocalDate.parse("12-Sep-13", dateFormatter), LocalTime.parse("10.00", timeFormatter), gillian, tony, s15));
		appointmentService.createOrUpdate(new Appointment(LocalDate.parse("12-Sep-13", dateFormatter), LocalTime.parse("12.00", timeFormatter), jill, tony, s15));
	}

}
