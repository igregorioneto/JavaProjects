package com.backend.backend.controller;

import com.backend.backend.business.AccountBusiness;
import com.backend.backend.business.UserBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.dto.AccountDTO;
import com.backend.backend.entity.Account;
import com.backend.backend.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/account")
public class AccountController extends GenericControllerImpl<Account, UUID, AccountBusiness> {
    @Autowired
    private UserBusiness userBusiness;
    public AccountController(AccountBusiness service) {
        super(service);
    }

    @PostMapping("/new")
    public ResponseEntity<Account> create(@RequestBody AccountDTO dto) {
        Account account = new Account();
        User user = userBusiness.getById(dto.getUser_id()).orElse(null);
        if(user != null) {
            account.setUser(user);
        } else {
            throw new EntityNotFoundException("Not found User");
        }

        if(dto.getBalance() != null) {
            account.setBalance(dto.getBalance());
        } else {
            account.setBalance(0.0);
        }

        return ResponseEntity.ok(service.save(account));
    }
}
