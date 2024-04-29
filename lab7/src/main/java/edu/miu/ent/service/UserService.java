package edu.miu.ent.service;

import edu.miu.ent.dto.UserRequest;
import edu.miu.ent.dto.UserResponse;
import edu.miu.ent.exception.DuplicateUserException;
import edu.miu.ent.model.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User addNewUser(User newUser);
    User getUserById(Integer userId);
    User updateUser(User editedUser);
    void deleteUserById(Integer userId);


    User savePatient(User patient);

    public abstract Page<User> getUsersPaged(int pageNo);

    List<User> searchUsers(String searchString);

    UserResponse createDentist(UserRequest userRequest) throws DuplicateUserException;
    UserResponse createPatient(UserRequest userRequest) throws DuplicateUserException;
    UserResponse createManager(UserRequest userRequest) throws DuplicateUserException;

    boolean authenticateUser(String email, String password);

    boolean deleteUser(Integer id);
}