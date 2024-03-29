package com.backend.backend.controller;

import com.backend.backend.business.UserBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.UserDTO;
import com.backend.backend.entity.User;
import com.backend.backend.util.UserDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericControllerImpl<User, UUID, UserBusiness> {

    public UserController(UserBusiness service) {
        super(service);
    }

    /*@Autowired
    private UserBusiness business;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @GetMapping
    public ResponseEntity<List<UserDTO>> get() {
        List<User> users = business.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user: users) {
            usersDTO.add(userDTOConverter.convertToDTO(user));
        }
        return ResponseEntity.ok(usersDTO);
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody UserDTO userDTO) {
       User user = userDTOConverter.convertToEntity(userDTO);
       User newUser = business.save(user);
       return ResponseEntity.ok(newUser.getId());
    }*/

}
