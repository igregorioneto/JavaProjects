package com.backend.cashflow.controller;

import com.backend.cashflow.model.Transaction;
import com.backend.cashflow.model.User;
import com.backend.cashflow.service.TransactionService;
import com.backend.cashflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    public TransactionController() {
    }

    @GetMapping
    public List<Transaction> getAllUsers() {
        return service.getAllTransactions();
    }

}
