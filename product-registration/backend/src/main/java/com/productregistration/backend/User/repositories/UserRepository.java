package com.productregistration.backend.User.repositories;

import com.productregistration.backend.User.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository implements IUserRepository {
    @Autowired
    private UserJPARepository repository;

    @Override
    public User findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }
}
