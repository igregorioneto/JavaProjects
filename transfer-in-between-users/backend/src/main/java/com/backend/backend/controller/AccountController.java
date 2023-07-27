package com.backend.backend.controller;

import com.backend.backend.business.AccountBusiness;
import com.backend.backend.business.UserBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.AccountDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Account;
import com.backend.backend.entity.User;
import com.backend.backend.exception.AccountNotFoundException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<SuccessResponseDTO<?>> create(@RequestBody AccountDTO dto) {
        SuccessResponseDTO<Account> successResponse = new SuccessResponseDTO<>();
        SuccessResponseDTO<String> errorResponse = new SuccessResponseDTO<>();

        Account account = new Account();
        User user = userBusiness.getById(dto.getUser_id()).orElse(null);

        if(service.exintingUserInAccount(user)) {
            errorResponse.setMessage("Error");
            errorResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setData("User contains account");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        if(user != null) {
            account.setUser(user);
        } else {
            errorResponse.setMessage("Error");
            errorResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setData("Not found User");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        if(dto.getBalance() != null) {
            account.setBalance(dto.getBalance());
        } else {
            account.setBalance(0.0);
        }

        Account a = service.save(account);
        successResponse.setMessage("Success");
        successResponse.setHttpStatus(HttpStatus.OK.value());
        successResponse.setData(a);

        return ResponseEntity.ok(successResponse);
    }
}
