package com.project.AuctionHouse.mappers;

import com.project.AuctionHouse.dtos.UserDTO;
import com.project.AuctionHouse.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserMapperTest {

    @Test
    public void testToEntity() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john");
        userDTO.setPassword("password");

        User user = UserMapper.toEntity(userDTO);

        Assertions.assertEquals("john", user.getUsername());
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    public void testToDTO() {
        User user = new User();
        user.setUsername("jane");
        user.setPassword("secret");

        UserDTO userDTO = UserMapper.toDTO(user);

        Assertions.assertEquals("jane", userDTO.getUsername());
        Assertions.assertEquals("secret", userDTO.getPassword());
    }

    @Test
    public void testToDTOList() {
        User user1 = new User();
        user1.setUsername("john");
        user1.setPassword("password");

        User user2 = new User();
        user2.setUsername("jane");
        user2.setPassword("secret");

        List<User> users = Arrays.asList(user1, user2);

        List<UserDTO> userDTOs = UserMapper.toDTO(users);

        Assertions.assertEquals(2, userDTOs.size());
        Assertions.assertEquals("john", userDTOs.get(0).getUsername());
        Assertions.assertEquals("password", userDTOs.get(0).getPassword());
        Assertions.assertEquals("jane", userDTOs.get(1).getUsername());
        Assertions.assertEquals("secret", userDTOs.get(1).getPassword());
    }
}
