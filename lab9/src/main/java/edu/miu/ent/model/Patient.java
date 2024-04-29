package edu.miu.ent.model;

import edu.miu.ent.util.Constants;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue(Constants.PATIENT)
public class Patient extends User{
    private String dob;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;
}
