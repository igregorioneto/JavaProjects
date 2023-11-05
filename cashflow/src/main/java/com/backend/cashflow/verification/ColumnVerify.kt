package com.backend.cashflow.verification

import com.backend.cashflow.enums.StringLength
import org.springframework.stereotype.Component

@Component
class ColumnVerify {
    fun isColumnValid(s: String, field: StringLength): Boolean {
        return s != null && s.isNotEmpty() && s.length > field.minLength && s.length < field.maxLength;
    }
}