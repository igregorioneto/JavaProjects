package com.productregistration.backend.User.controllers;

import com.productregistration.backend.User.dto.CreatedUserDTO;
import com.productregistration.backend.User.entities.User;
import com.productregistration.backend.User.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginUserController {
    @Autowired
    private AuthenticationManager authentication;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody CreatedUserDTO userDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        Authentication authentication = this.authentication.authenticate(authenticationToken);

        var user = (User) authentication.getPrincipal();
        var token = tokenService.getToken(user);

        return ResponseEntity.ok(token);
    }
}
