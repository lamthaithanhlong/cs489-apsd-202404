package edu.miu.ent.repository;


import edu.miu.ent.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    @Query("SELECT a FROM Appointment a WHERE a.status = :status")
    List<Appointment> findByStatus(String status);
}
