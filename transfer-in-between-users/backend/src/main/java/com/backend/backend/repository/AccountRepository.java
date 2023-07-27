package com.backend.backend.repository;

import com.backend.backend.entity.Account;
import com.backend.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account findByUserId(UUID id);
}
