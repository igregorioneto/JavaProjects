package com.backend.backend.controller;

import com.backend.backend.business.UserBusiness;
import com.backend.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserBusiness business;

    @GetMapping
    public List<User> get() {
        return business.findAll();
    }

    @PostMapping
    public User post(@RequestBody User user) {
       var newUser = new User();
       newUser.setName(user.getName());
       newUser.setBirthday(user.getBirthday());
       newUser.setEmail(user.getEmail());
       return business.create(newUser);
    }

}
