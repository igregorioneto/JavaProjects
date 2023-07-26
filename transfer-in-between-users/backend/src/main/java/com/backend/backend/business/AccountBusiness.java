package com.backend.backend.business;

import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.Account;
import com.backend.backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountBusiness extends GenericServiceImpl<Account, UUID, AccountRepository> {
    public AccountBusiness(AccountRepository repository) {
        super(repository);
    }
}
