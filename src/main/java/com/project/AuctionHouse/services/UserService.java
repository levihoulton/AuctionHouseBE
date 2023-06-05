package com.project.AuctionHouse.services;

import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.mappers.UserMapper;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public UserDTO getUserByUsername(String username) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            return UserMapper.toDTO(user.get());
        } else {
            //TODO add logging
            return null;
        }
    }

    public UserDTO updateUser(String username, UserDTO userDTO) {
            User user = UserMapper.toEntity(userDTO);
            User savedUser = userRepository.save(user);
            return UserMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.toDTO(users);

    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteById(username);
    }

    public boolean existByID(String username) {
        return userRepository.existsById(username);
    }

}

