package com.backend.cashflow.verification

import com.backend.cashflow.enums.StringLength
import org.springframework.stereotype.Component

@Component
class ColumnVerify {
    fun isColumnValid(s: String, field: StringLength): Boolean {
        return s != null &&
                s.isNotEmpty() &&
                s.isNotBlank() &&
                s.length > field.minLength && s.length < field.maxLength;
    }

    fun isColumnValueValid(value: Double, field: StringLength): Boolean {
        return value != null &&
                value >= field.minLength && value <= field.maxLength;
    }
}