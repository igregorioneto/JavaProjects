package com.backend.cashflow.verification;

import com.backend.cashflow.enums.StringLength;
import org.springframework.stereotype.Component;

@Component
public class ColumnVerify {

    public boolean isColumnValid(String s, StringLength field) {
        return s != null &&
                !s.isEmpty() &&
                !s.isBlank() &&
                s.length() > field.getMinLength() && s.length() < field.getMaxLength();
    }

    public boolean isColumnValueValid(double value, StringLength field) {
        return value >= field.getMinLength() && value <= field.getMaxLength();
    }
}