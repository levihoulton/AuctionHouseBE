package com.project.AuctionHouse.mappers;

import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static List<UserDTO> toDTO(List<User> users) {
//        List<UserDTO> userDTOS = new ArrayList<>();
//        users.forEach( user -> {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setUsername(user.getUsername());
//            userDTO.setPassword(user.getPassword());
//            userDTOS.add(userDTO);
//        });
//        return userDTOS;

        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

}

