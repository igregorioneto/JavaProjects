package com.backend.cashflow.model

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_accounts")
class Account(
    var email: String? = null,
    var password: String? = null,

    @OneToOne
    @JoinColumn(name = "user_id")
    var user: User
) : BaseEntity()