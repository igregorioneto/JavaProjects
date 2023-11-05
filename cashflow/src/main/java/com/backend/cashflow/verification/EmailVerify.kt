package com.backend.cashflow.verification;

import org.springframework.stereotype.Component;

@Component
class EmailVerify {
    /*
     * Verificador formato de E-mail;
     * @param String
     * @return boolean
     * */
    fun isEmailValid(email: String): Boolean {
        val emailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern.toRegex());
    }
}
