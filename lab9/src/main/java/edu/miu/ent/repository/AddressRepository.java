package edu.miu.ent.repository;


import edu.miu.ent.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
