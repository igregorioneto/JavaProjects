package com.backend.cashflow.verification;

import org.springframework.stereotype.Component;

@Component
public class PasswordVerify {

    public boolean isPasswordValid(String password) {
        String uppercaseRegex = "[A-Z]";
        String lowercaseRegex = "[a-z]";
        String specialCharacterRegex = "[!@#\\$%^&*()]";
        String numberRegex = "[0-9]";

        boolean containsUppercase = password.matches(".*" + uppercaseRegex + ".*");
        boolean containsLowercase = password.matches(".*" + lowercaseRegex + ".*");
        boolean containsCharacterRegex = password.matches(".*" + specialCharacterRegex + ".*");
        boolean containsNumberRegex = password.matches(".*" + numberRegex + ".*");

        return containsUppercase && containsLowercase && containsCharacterRegex && containsNumberRegex;
    }
}
