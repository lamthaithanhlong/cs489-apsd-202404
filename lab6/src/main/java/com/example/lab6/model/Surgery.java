package com.example.lab6.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Surgery {
    @Id
    private String surgeryNumber;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // Getters and setters...
}