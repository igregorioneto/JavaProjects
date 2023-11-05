package com.backend.cashflow.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordHasher {
    private val passwordEnconder = BCryptPasswordEncoder();

    fun hashPassword(password: String): String {
        return passwordEnconder.encode(password);
    }

    fun verifyPassword(password: String, hashedPassword: String): Boolean {
        return passwordEnconder.matches(password, hashedPassword);
    }
}