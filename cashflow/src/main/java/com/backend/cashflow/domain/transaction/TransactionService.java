package com.backend.cashflow.domain.transaction;

import com.backend.cashflow.domain.transaction.Transaction;
import com.backend.cashflow.domain.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {


    @Autowired
    private TransactionRepository repository;

    public TransactionService() {
    }

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction makeWithdrawal(Transaction transaction) {
        return repository.save(transaction);
    }

}
