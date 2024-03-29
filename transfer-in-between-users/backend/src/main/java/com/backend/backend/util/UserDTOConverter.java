package com.backend.backend.util;

import com.backend.backend.dto.UserDTO;
import com.backend.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter extends ConvertDTO<UserDTO, User>{

    @Override
    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
