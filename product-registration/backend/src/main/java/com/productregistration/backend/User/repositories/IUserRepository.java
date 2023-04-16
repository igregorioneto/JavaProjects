package com.productregistration.backend.User.repositories;

import com.productregistration.backend.User.entities.User;

import java.util.List;

public interface IUserRepository {
    public User findByUsername(String username);

    public User save(User user);

    public List<User> findAll();
}
