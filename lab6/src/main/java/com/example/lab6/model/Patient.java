package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "patients")
public class Patient {
    @Id
    private String patientNumber;
    private String name;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    // Getters and setters...
}