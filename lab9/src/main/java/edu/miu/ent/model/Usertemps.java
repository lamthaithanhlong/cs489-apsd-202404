package edu.miu.ent.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING,columnDefinition = "VARCHAR(255) default 'patient'")
@Table(name = "usertemps")
public class Usertemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usertempId;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "addressId")
    private Address address;





}
