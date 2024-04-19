package com.example.lab6.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Surgery {
    @Id
    private String id;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "surgery")
    private Set<Appointment> appointments;
}
