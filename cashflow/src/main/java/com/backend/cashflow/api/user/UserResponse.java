package com.backend.cashflow.api.user;

import java.time.LocalDateTime;

public record UserResponse(String name, Double balance, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
