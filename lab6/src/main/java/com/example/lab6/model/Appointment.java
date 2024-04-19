package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Surgery surgery;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    public Appointment(LocalDate parse, LocalTime parse1, Patient gillian, Dentist tony, Surgery s15) {
    }
}