package edu.miu.ent.repository;

import edu.miu.ent.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "SELECT * FROM users u LEFT JOIN appointment a ON u.user_id = a.patient_id WHERE u.type = 'patient' AND u.user_id = :userId", nativeQuery = true)
    List<Patient> findPatientWithAppointmentsByUserIdNativeQuery(@Param("userId") Integer userId);
}
