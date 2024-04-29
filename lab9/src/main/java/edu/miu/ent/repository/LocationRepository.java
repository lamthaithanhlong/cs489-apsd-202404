package edu.miu.ent.repository;


import edu.miu.ent.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
