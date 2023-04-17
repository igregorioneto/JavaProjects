package com.productregistration.backend.User.controllers;

import com.productregistration.backend.User.dto.CreatedUserDTO;
import com.productregistration.backend.User.entities.User;
import com.productregistration.backend.User.repositories.UserRepository;
import com.productregistration.backend.User.services.CreatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class CreatedUserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<User> created(@RequestBody CreatedUserDTO userDTO) {
        try {
            CreatedUserService service = new CreatedUserService(repository);
            User user = new User(userDTO.getUsername(), bCryptPasswordEncoder().encode(userDTO.getPassword()));
            return new ResponseEntity<>(service.execute(user), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
