package com.backend.cashflow.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_users")
class User (
    var name: String,
    var email: String,
    var password: String
) : BaseEntity() {
    constructor() : this("", "", "")
}