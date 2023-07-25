package com.backend.backend.controller;

import com.backend.backend.business.UserBusiness;
import com.backend.backend.dto.UserDTO;
import com.backend.backend.entity.User;
import com.backend.backend.util.UserDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserBusiness business;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @GetMapping
    public List<User> get() {
        return business.findAll();
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody UserDTO userDTO) {
       User user = userDTOConverter.convertToEntity(userDTO);
       User newUser = business.create(user);
       return ResponseEntity.ok(newUser.getId());
    }

}
