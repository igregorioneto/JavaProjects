package com.backend.cashflow.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity (
    @Suppress("UNSED")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
) {
    constructor() : this(0)
}