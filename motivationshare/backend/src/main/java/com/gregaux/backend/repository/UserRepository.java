package com.gregaux.backend.repository;

import com.gregaux.backend.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User> {
}
