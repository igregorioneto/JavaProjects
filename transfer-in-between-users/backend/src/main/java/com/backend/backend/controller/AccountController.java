package com.backend.backend.controller;

import com.backend.backend.business.AccountBusiness;
import com.backend.backend.business.UserBusiness;
import com.backend.backend.core.GenericControllerImpl;
import com.backend.backend.dto.AccountDTO;
import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.entity.Account;
import com.backend.backend.entity.User;
import com.backend.backend.util.ResponseMessage;
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

    @Autowired
    private ResponseMessage<Account> successResponse;

    @Autowired
    private ResponseMessage<String> errorResponse;

    public AccountController(AccountBusiness service) {
        super(service);
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDTO<?>> create(@RequestBody AccountDTO dto) {
        try {
            Account account = new Account();
            User user = userBusiness.getById(dto.getUser_id()).orElse(null);

            if(service.exintingUserInAccount(user)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorResponse.MessageReturn("Error", HttpStatus.NOT_FOUND.value(), "User contains account")
                );
            }

            if(user != null) {
                account.setUser(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        errorResponse.MessageReturn("Error", HttpStatus.NOT_FOUND.value(), "Not found User")
                );
            }

            if(dto.getBalance() != null) {
                account.setVoucher(dto.getBalance());
            } else {
                account.setVoucher(0.0);
            }

            Account a = service.save(account);

            return ResponseEntity.ok(
                    successResponse.MessageReturn("Success", HttpStatus.OK.value(), a)
            );
        } catch (InternalError e) {
            throw new InternalError(e.getMessage());
        }

    }
}
