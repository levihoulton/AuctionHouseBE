package com.project.AuctionHouse.services;

import com.project.AuctionHouse.Mappers.UserMapper;
import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.models.User;
import com.project.AuctionHouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findByUsername(username);
        return UserMapper.toDTO(user);
    }

    public UserDTO updateUser(String username, UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        user.setUsername(username);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}

