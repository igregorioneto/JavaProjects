package com.backend.cashflow.enums

enum class StringLength(val minLength: Int, val maxLength: Int) {
    NAME(3,80),
    PASSWORD(6, 20),
    BALANCE(50,1000)
}