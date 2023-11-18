package com.backend.cashflow.model

import com.backend.cashflow.enums.TypeTransaction
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_transactions")
class Transaction (
    var price: Double? = null,
    var date: String? = null,
    var type: TypeTransaction? = null,
    var toUser: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User
) : BaseEntity()