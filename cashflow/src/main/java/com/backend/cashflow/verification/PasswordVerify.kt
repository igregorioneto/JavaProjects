package com.backend.cashflow.verification

import org.springframework.stereotype.Component

@Component
class PasswordVerify {
    fun isPasswordValid(password: String): Boolean {
        val uppercaseRegex = Regex("[A-Z]")
        val lowercaseRegex = Regex("[a-z]")
        val specialCharacterRegex = Regex("[!@#\$%^&*()]")
        val numberRegex = Regex("[0-9]")

        val containsUppercase = uppercaseRegex.containsMatchIn(password)
        val containsLowercase = lowercaseRegex.containsMatchIn(password)
        val containsCharacterRegex = specialCharacterRegex.containsMatchIn(password)
        val containsNumberRegex = numberRegex.containsMatchIn(password)

        return containsUppercase && containsLowercase && containsCharacterRegex && containsNumberRegex
    }
}