package me.jaddy.kotlin_webflux.member.domain

import org.springframework.data.annotation.Id

data class Account(
    @Id
    val id: Long?,
    var name: String,
    val teamId: Long?,
) {

    constructor(name: String) : this(null, name, null)
}