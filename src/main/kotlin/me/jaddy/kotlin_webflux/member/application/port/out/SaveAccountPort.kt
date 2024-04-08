package me.jaddy.kotlin_webflux.member.application.port.out

import me.jaddy.kotlin_webflux.member.domain.Account

interface SaveAccountPort {
    suspend fun saveAccount(account: Account): Account
}