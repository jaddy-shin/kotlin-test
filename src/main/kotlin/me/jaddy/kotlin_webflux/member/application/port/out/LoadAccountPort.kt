package me.jaddy.kotlin_webflux.member.application.port.out

import me.jaddy.kotlin_webflux.member.domain.Account

interface LoadAccountPort {


    suspend fun loadAccountOrNull(id: Long): Account?

    suspend fun loadAccount(id: Long): Account
}