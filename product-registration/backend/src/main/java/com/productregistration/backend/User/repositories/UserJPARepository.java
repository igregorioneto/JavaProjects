package com.productregistration.backend.User.repositories;

import com.productregistration.backend.User.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
