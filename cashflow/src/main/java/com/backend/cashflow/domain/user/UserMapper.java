package com.backend.cashflow.domain.user;

import com.backend.cashflow.api.user.UserRequest;
import com.backend.cashflow.api.user.UserResponse;
import org.springframework.util.StringUtils;

public class UserMapper {
    public static User updateUserFromDTO(UserRequest userRequest, User user) {
        final String name = StringUtils.hasText(userRequest.name()) ? userRequest.name() : user.getName();
        final Double balance = Double.hashCode(userRequest.balance()) > 0 ? userRequest.balance() : user.getBalance();
        return new User(name, balance);
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getName(), user.getBalance(), user.getCreatedAt(), user.getUpdatedAt());
    }
}
