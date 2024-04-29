package edu.miu.ent.model;

import edu.miu.ent.util.Constants;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(Constants.MANAGER)
public class Manager extends User {
    String officePhoneNumber;
}
