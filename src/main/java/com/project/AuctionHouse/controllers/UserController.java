package com.project.AuctionHouse.controllers;

import com.project.AuctionHouse.dtos.UserDTO;
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

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Boolean> createUser(@RequestBody UserDTO userDTO) {
        try {
            if (!userService.existByID(userDTO.getUsername())) {
                UserDTO createdUser = userService.createUser(userDTO);
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(false, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        try {
            UserDTO userDTO = userService.getUserByUsername(username);
            if (userDTO != null) {
                return new ResponseEntity<>(userDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getUsers() {
        try {
            List<UserDTO> userDTOS = userService.getAllUsers();
            return new ResponseEntity<>(userDTOS, HttpStatus.OK);
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        try {
            if (userService.existByID(username) && userDTO.getUsername().equals(username)) {
                UserDTO updatedUser = userService.updateUser(username, userDTO);
                //TODO log updatedUser
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String username) {
        try {
            if (userService.existByID(username)) {
                userService.deleteUserByUsername(username);
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(false, HttpStatus.EXPECTATION_FAILED);
        }

    }

}

