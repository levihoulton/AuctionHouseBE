package com.project.AuctionHouse.services;

import com.project.AuctionHouse.Mappers.UserMapper;
import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
            if (userRepository.existsById(userDTO.getUsername())) {
                User user = UserMapper.toEntity(userDTO);
                User savedUser = userRepository.save(user);
                return UserMapper.toDTO(savedUser);
            } else {
                //TODO add logging
                return null;
            }
    }

    public UserDTO getUserByUsername(String username) {
            Optional<User> user = userRepository.findById(username);
            if (user.isPresent()){
                return UserMapper.toDTO(user.get());
            } else {
                //TODO add logging
                return null;
            }
    }

    public UserDTO updateUser(String username, UserDTO userDTO) {
            if(userRepository.existsById(username)) {
                User user = UserMapper.toEntity(userDTO);
                user.setUsername(username);
                User savedUser = userRepository.save(user);
                return UserMapper.toDTO(savedUser);
            } else {
                //TODO add logging
                return null;
            }
    }

    public List<UserDTO> getAllUsers(){
            List<User> users = userRepository.findAll();
            return UserMapper.toDTO(users);

    }

    public ResponseEntity deleteUserByUsername(String username) {

            if (userRepository.existsById(username)){
                userRepository.deleteById(username);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                //TODO add logging
                return null;
            }
    }

}

