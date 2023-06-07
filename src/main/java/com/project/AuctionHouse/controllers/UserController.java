package com.project.AuctionHouse.controllers;

import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.mappers.UserMapper;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {


    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            if (!userService.existByID(userDTO.getUsername())) {
                UserDTO createdUser = userService.createUser(userDTO);
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(false, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username) {
        try {
            UserDTO userDTO = userService.getUserByUsername(username);
            if (userDTO != null) {
                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        try {
            List<UserDTO> userDTOS = userService.getAllUsers();
            return new ResponseEntity<>(userDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
        try {
            if (userService.existByID(userDTO.getUsername())) {
                UserDTO updatedUser = userService.updateUser(userDTO);
                //TODO log updatedUser
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } else {
                //not found
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        try {
            if (userService.existByID(username)) {
                userService.deleteUserByUsername(username);
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){
        try {
            User user = UserMapper.toEntity(userDTO);
            if (userService.authenticateUser(user.getUsername(), user.getPassword())){
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}

