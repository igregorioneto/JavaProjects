package com.backend.cashflow.service;

import com.backend.cashflow.enums.StringLength;
import com.backend.cashflow.model.Account;
import com.backend.cashflow.model.Transaction;
import com.backend.cashflow.model.User;
import com.backend.cashflow.repository.AccountRepository;
import com.backend.cashflow.repository.TransactionRepository;
import com.backend.cashflow.util.PasswordHasher;
import com.backend.cashflow.verification.ColumnVerify;
import com.backend.cashflow.verification.EmailVerify;
import com.backend.cashflow.verification.PasswordVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final EmailVerify emailVerify;
    private final ColumnVerify columnVerify;
    private final PasswordHasher passwordHasher;
    private final PasswordVerify passwordVerify;


    public AccountService(AccountRepository repository,
                          EmailVerify emailVerify,
                          ColumnVerify columnVerify,
                          PasswordHasher passwordHasher,
                          PasswordVerify passwordVerify) {
        this.repository = repository;
        this.emailVerify = emailVerify;
        this.columnVerify = columnVerify;
        this.passwordHasher = passwordHasher;
        this.passwordVerify = passwordVerify;
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return repository.findById(id);
    }

    /*
    * @param Account
    * @return Account
    * Criando uma conta
    * */
    public Account createAccount(Account account) {
        if (isEmailAlreadyRegistered(account.getEmail())) {
            throw new IllegalArgumentException("E-mail cadastrado. Por favor, digitar um novo E-mail.");
        }

        if (!emailVerify.isEmailValid(account.getEmail())) {
            throw new IllegalArgumentException("E-mail inválido. O E-mail deve seguir com um formato válido.");
        }

        if (!columnVerify.isColumnValid(account.getPassword(), StringLength.PASSWORD)) {
            throw new IllegalArgumentException("O Campo senha esta nulo ou vazio ou sua quantidade de caracteres é menor que "
                    + StringLength.PASSWORD.getMinLength() +
                    " e maior que " + StringLength.PASSWORD.getMaxLength());
        }

        if (!passwordVerify.isPasswordValid(account.getPassword())) {
            throw new IllegalArgumentException("Senha deve conter pelo menos 1 Letra Maiúscula, 1 Letra Minúscula, 1 Caractere Especial e 1 Número");
        }

        String password = passwordHasher.hashPassword(account.getPassword());
        account.setPassword(password);

        return repository.save(account);
    }

    /*
     * @param String
     * @return boolean
     * Verifica se o e-mail esta registrado
     * */
    private boolean isEmailAlreadyRegistered(String email) {
        return repository.existsEmail(email);
    }

}
