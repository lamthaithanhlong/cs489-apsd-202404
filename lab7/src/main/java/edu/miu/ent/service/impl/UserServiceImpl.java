package edu.miu.ent.service.impl;

import edu.miu.ent.dto.UserRequest;
import edu.miu.ent.dto.UserResponse;
import edu.miu.ent.exception.DuplicateUserException;
import edu.miu.ent.model.Dentist;
import edu.miu.ent.model.Manager;
import edu.miu.ent.model.Patient;
import edu.miu.ent.model.User;
import edu.miu.ent.repository.UserRepository;
import edu.miu.ent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addNewUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(User editedUser) {
        return userRepository.save(editedUser);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }





    @Override
    public User savePatient(User patient) {
//        patient.setDtype("patient");
//        patient.setRole("patient");
        return userRepository.save(patient);
    }

    @Override
    public Page<User> getUsersPaged(int pageNo) {
        return userRepository.findAll(PageRequest.of(pageNo, 3, Sort.Direction.ASC, "firstName"));
    }

    @Override
    public List<User> searchUsers(String searchString) {
        return userRepository.findByFirstNameContainingOrLastNameContainingOrEmailContainingOrPhoneNumberContaining(searchString,searchString,searchString,searchString);
    }

    @Override
    public UserResponse createDentist(UserRequest userRequest) throws DuplicateUserException {
        var existingUser = userRepository.findUserByEmail(userRequest.email());
        if(existingUser != null){
            return null;
        }

        Dentist user = new Dentist();

        user.setEmail(userRequest.email());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.password()));
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setSpecialization(userRequest.specialization());
        var savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserResponse createPatient(UserRequest userRequest) throws DuplicateUserException {
        var existingUser = userRepository.findUserByEmail(userRequest.email());
        if(existingUser != null){
            return null;
        }

        Patient user = new Patient();

        user.setEmail(userRequest.email());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.password()));
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setDob(userRequest.dob());
        var savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserResponse createManager(UserRequest userRequest) throws DuplicateUserException {
        var existingUser = userRepository.findUserByEmail(userRequest.email());
        if(existingUser != null){
            return null;
        }
        Manager user = new Manager();
        user.setEmail(userRequest.email());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.password()));
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setOfficePhoneNumber(userRequest.officePhoneNumber());
        var savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getUserId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );
    }


    @Override
    public boolean authenticateUser(String email, String password) {
        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found with email: "+ email);
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

}