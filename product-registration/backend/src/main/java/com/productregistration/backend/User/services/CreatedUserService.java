package com.productregistration.backend.User.services;

import com.productregistration.backend.User.entities.User;
import com.productregistration.backend.User.repositories.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreatedUserService {
    private IUserRepository repository;

    public CreatedUserService(IUserRepository repository) {
        this.repository = repository;
    }

    public User execute(User user) {
        return this.repository.save(user);
    }
}
