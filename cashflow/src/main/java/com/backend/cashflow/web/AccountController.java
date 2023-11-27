package com.backend.cashflow.web;

import com.backend.cashflow.domain.account.Account;
import com.backend.cashflow.domain.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/accounts")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> account = service.getAccountById(id);
        return account.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        try {
            Account createAccount = service.createAccount(account);
            return new ResponseEntity<>(createAccount, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
