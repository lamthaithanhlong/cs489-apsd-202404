package edu.miu.ent.controller;

import edu.miu.ent.dto.UserRequest;
import edu.miu.ent.dto.UserResponse;
import edu.miu.ent.exception.DuplicateUserException;
import edu.miu.ent.model.User;
import edu.miu.ent.util.Constants;
import edu.miu.ent.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import edu.miu.ent.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(Constants.API_VERSION+"/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(value = {"/test"})
    public List<User> searchTest(@RequestParam String searchString) {
        System.out.println(searchString);
        return userService.searchUsers(searchString);
    }



    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setUserId(id);
        return userService.updateUser(user);
    }


    @GetMapping("/list")
    public ModelAndView listUsers(@RequestParam(defaultValue = "0") int pageNo) {
        var modelAndView = new ModelAndView();
        var users = userService.getUsersPaged(pageNo);
        modelAndView.addObject("users", users);
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("secured/sysadmin/user/list");
        return modelAndView;
    }


    @GetMapping(value = {"/search"})
    public ModelAndView searchPublishers(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var users = userService.searchUsers(searchString);
        modelAndView.addObject("users", users);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/sysadmin/user/searchResult");
        return modelAndView;
    }


    @PostMapping(value = {"/register"})
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createPatient(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequest userRequest) {
        String email = userRequest.email();
        String password = userRequest.password();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtil.generateToken(authentication);
            String responseBody = String.format("{\"token\":\"%s\"}", token);
            return ResponseEntity.ok(responseBody);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


    /*@PostMapping("/login")  //teacher
    public ResponseEntity<String> login(@RequestBody @Valid UserRequest userRequest) {
        //1. Authentication
        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.email(), userRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        //2. create JWT
        var token = jwtUtil.generateToken(auth);
        return ResponseEntity.ok(token);
    }*/


    @PostMapping("/create-dentist")
    public ResponseEntity<UserResponse> createDentist(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createDentist(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @PostMapping("/create-manager")
    public ResponseEntity<UserResponse> createManager(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createManager(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    @PostMapping("/create-patient")
    public ResponseEntity<UserResponse> createPatient(@RequestBody @Valid UserRequest userRequest) throws DuplicateUserException {
        var userResponse = userService.createPatient(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}