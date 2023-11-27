package com.backend.cashflow.web;

import com.backend.cashflow.api.user.UserRequest;
import com.backend.cashflow.api.user.UserResponse;
import com.backend.cashflow.domain.user.User;
import com.backend.cashflow.domain.user.UserMapper;
import com.backend.cashflow.domain.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = service.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
        try {
            UserResponse u = service.createUser(request).map(UserMapper::toResponse).block();
            return ResponseEntity.status(HttpStatus.CREATED).body(u);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
