package com.backend.cashflow.enums

enum class TypeTransaction(type: String) {
    WITHDRAW("withdraw"),
    TRANSFER("transfer"),
    DEPOSIT("deposit")
}