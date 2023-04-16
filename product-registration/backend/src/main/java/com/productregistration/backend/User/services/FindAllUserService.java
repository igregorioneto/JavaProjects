package com.productregistration.backend.User.services;

import com.productregistration.backend.User.entities.User;
import com.productregistration.backend.User.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUserService {
    private IUserRepository repository;

    public FindAllUserService(IUserRepository repository) {
        this.repository = repository;
    }

    public List<User> execute() {
        return this.repository.findAll();
    }
}
