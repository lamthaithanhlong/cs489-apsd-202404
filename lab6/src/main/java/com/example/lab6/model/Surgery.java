package com.example.lab6.model;

import jakarta.persistence.*;

import java.util.List;

import java.util.Set;

@Entity
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "surgery")
    private Set<Appointment> appointments;
}
