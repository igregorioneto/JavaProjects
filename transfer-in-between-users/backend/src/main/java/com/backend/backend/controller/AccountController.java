package com.backend.backend.controller;

import com.backend.backend.business.AccountBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountController extends GenericControllerImpl<Account, UUID, AccountBusiness> {
    public AccountController(AccountBusiness service) {
        super(service);
    }
}
