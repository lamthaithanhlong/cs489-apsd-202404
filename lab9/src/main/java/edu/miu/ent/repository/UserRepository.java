package edu.miu.ent.repository;


import edu.miu.ent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {



    List<User> findByFirstNameContainingOrLastNameContainingOrEmailContainingOrPhoneNumberContaining(String firstNameSearchString, String lastNameSearchString, String emailSearchString, String phoneNumberSearchString);
    User findUserByEmail(String email);

    User findByEmail(String email);


}
