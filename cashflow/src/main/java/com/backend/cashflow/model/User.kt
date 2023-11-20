package com.backend.cashflow.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_users")
class User (
    var name: String? = null,
    var balance: Double? = null,

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    var account: Account,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
    @JsonIgnore
    var transactions: List<Transaction>
) : BaseEntity()