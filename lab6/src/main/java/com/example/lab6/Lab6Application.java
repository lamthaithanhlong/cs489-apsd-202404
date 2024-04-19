package com.example.lab6;

import com.example.lab6.model.*;
import com.example.lab6.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@SpringBootApplication
public class Lab6Application {
	private final PatientService patientService;
	private final DentistService dentistService;
	private final AppointmentService appointmentService;
	private final SurgeryService surgeryService;
	private final AddressService addressService;

	public Lab6Application(PatientService patientService,
					  DentistService dentistService,
					  AppointmentService appointmentService,
					  SurgeryService surgeryService,
						AddressService addressService) {
		this.appointmentService = appointmentService;
		this.dentistService = dentistService;
		this.surgeryService = surgeryService;
		this.patientService = patientService;
		this.addressService = addressService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab6Application.class, args);
	}

	@Bean
	public CommandLineRunner initData() {
		return args -> {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm");

			Address address1 = new Address();
			address1.setCity("Fairfield");
			address1.setState("Iowa");
			address1.setStreet("Iowa");
			address1.setZip("615666");
			addressService.saveAddress(address1);

			Address address2 = new Address();
			address2.setCity("Chicago");
			address2.setState("Tama");
			address2.setStreet("Texas");
			address2.setZip("75444");
			addressService.saveAddress(address2);

			Address address3 = new Address();
			address3.setCity("Chicago1");
			address3.setState("Tama");
			address3.setStreet("Texas");
			address3.setZip("75444");
			addressService.saveAddress(address3);

			Surgery surgery1 = new Surgery();
			surgery1.setId("S15");
			surgery1.setAddress(address1);

			Surgery surgery2 = new Surgery();
			surgery2.setId("S10");
			surgery2.setAddress(address2);

			Surgery surgery3 = new Surgery();
			surgery3.setId("S13");
			surgery3.setAddress(address3);

			// Creating or retrieving surgeries
			Surgery s15 = surgeryService.saveSurgery(surgery1);
			Surgery s10 = surgeryService.saveSurgery(surgery2);
			Surgery s13 = surgeryService.saveSurgery(surgery3);

			Dentist dentist1 = new Dentist();
			dentist1.setName("Tony Smith");

			Dentist dentist2 = new Dentist();
			dentist2.setName("Helen Pearson");

			Dentist dentist3 = new Dentist();
			dentist3.setName("Robin Plevin");

			// Creating or retrieving dentists
			Dentist tony = dentistService.saveDentist(dentist1);
			Dentist helen = dentistService.saveDentist(dentist2);
			Dentist robin = dentistService.saveDentist(dentist3);

			// Creating or retrieving patients
			Patient patient1 = new Patient();
			patient1.setPatientNumber("P100");
			patient1.setName("Gillian White");

			Patient patient2 = new Patient();
			patient2.setPatientNumber("P105");
			patient2.setName("Jill Bell");

			Patient patient3 = new Patient();
			patient3.setPatientNumber("P108");
			patient3.setName("Ian MacKay");

			Patient patient4 = new Patient();
			patient4.setPatientNumber("P110");
			patient4.setName("John Walker");

			Patient gillian = patientService.savePatient(patient1);
			Patient jill = patientService.savePatient(patient2);
			Patient ian = patientService.savePatient(patient3);
			Patient john = patientService.savePatient(patient4);

			try {
				Appointment appointment1 = new Appointment();
				appointment1.setAppointmentDate(LocalDate.of(2024,9,13));
				appointment1.setAppointmentTime(LocalTime.parse("10.00", timeFormatter));
				appointment1.setPatient(gillian);
				appointment1.setDentist(tony);
				appointment1.setSurgery(s15);

				Appointment appointment2 = new Appointment();
				appointment2.setAppointmentDate(LocalDate.of(2024,9,13));
				appointment2.setAppointmentTime(LocalTime.parse("12.00", timeFormatter));
				appointment2.setPatient(jill);
				appointment2.setDentist(tony);
				appointment2.setSurgery(s15);

				appointmentService.saveAppointment(appointment1);
				appointmentService.saveAppointment(appointment2);
			} catch (DateTimeParseException e) {
				System.out.println(e);
			}
		};
    }

}
