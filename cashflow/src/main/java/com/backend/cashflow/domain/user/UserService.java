package com.backend.cashflow.domain.user;

import com.backend.cashflow.api.user.UserRequest;
import com.backend.cashflow.enums.StringLength;
import com.backend.cashflow.util.PasswordHasher;
import com.backend.cashflow.util.verification.ColumnVerify;
import com.backend.cashflow.util.verification.EmailVerify;
import com.backend.cashflow.util.verification.PasswordVerify;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final EmailVerify emailVerify;
    private final ColumnVerify columnVerify;
    private final PasswordHasher passwordHasher;
    private final PasswordVerify passwordVerify;

    public UserService(UserRepository repository,
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

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User createUser(UserRequest userRequest) {
        if (!columnVerify.isColumnValid(userRequest.name(), StringLength.NAME)) {
            throw new IllegalArgumentException("O Campo nome esta nulo ou vazio ou sua quantidade de caracteres é menor que"
                    + StringLength.NAME.getMinLength() +
                    " e maior que " + StringLength.NAME.getMaxLength());
        }

        if (!columnVerify.isColumnValueValid(userRequest.balance(), StringLength.BALANCE)) {
            throw new IllegalArgumentException("O Campo balance esta nulo ou vazio ou valor é menor que "
                    + StringLength.BALANCE.getMinLength() +
                    " e maior que " + StringLength.BALANCE.getMaxLength());
        }

        User user = new User(userRequest.name(), userRequest.balance());

        return repository.save(user);
    }

    public User updateUser(Long id, User user) {
        if (repository.existsById(id)) {
            user.setId(id);
            return repository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
