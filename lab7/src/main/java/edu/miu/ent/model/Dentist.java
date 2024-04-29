package edu.miu.ent.model;

import edu.miu.ent.util.Constants;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue(Constants.DENTIST)
public class Dentist extends User {
    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointmentList;
}
