package com.backend.cashflow.util.verification;

import org.springframework.stereotype.Component;

@Component
public class EmailVerify {

    /*
     * Verificador formato de E-mail;
     * @param String
     * @return boolean
     * */
    public boolean isEmailValid(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}
