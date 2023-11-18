package com.backend.cashflow.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_users")
class User (
    var name: String? = null,
    var balance: Double? = null,
    var email: String? = null,
    var password: String? = null,
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    var transactions: List<Transaction>? = ArrayList()
) : BaseEntity()