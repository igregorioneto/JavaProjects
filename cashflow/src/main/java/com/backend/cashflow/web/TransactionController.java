package com.backend.cashflow.web;

import com.backend.cashflow.domain.transaction.Transaction;
import com.backend.cashflow.domain.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<?> makeWithdrawal(@RequestBody Transaction transaction) {
        try {
            Transaction t = service.makeWithdrawal(transaction);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

}
