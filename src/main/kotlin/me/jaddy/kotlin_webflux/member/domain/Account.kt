package me.jaddy.kotlin_webflux.member.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "accounts")
data class Account(
    @Id
    val id: Long?,
    var name: String,
    val teamId: Long?,
) {

    constructor(name: String) : this(null, name, null)
}