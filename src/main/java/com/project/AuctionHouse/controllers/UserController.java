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
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        try {
            if (userDTO != null) {
                UserDTO createdUser = userService.createUser(userDTO);
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        try {
            UserDTO userDTO = userService.getUserByUsername(username);
            if (userDTO != null) {
                return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
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
            return ResponseEntity.ok(userDTOS);
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        try {
            UserDTO updatedUser = userService.updateUser(username, userDTO);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //TODO log e
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        if(userService.deleteUserByUsername(username)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

