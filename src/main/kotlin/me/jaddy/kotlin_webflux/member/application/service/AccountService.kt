package me.jaddy.kotlin_webflux.member.application.service

import me.jaddy.kotlin_webflux.member.application.port.out.LoadAccountPort
import me.jaddy.kotlin_webflux.member.application.port.out.SaveAccountPort
import me.jaddy.kotlin_webflux.member.domain.Account
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val loadAccountPort: LoadAccountPort,
    private val saveAccountPort: SaveAccountPort,
) {

    @Transactional(readOnly = true)
    suspend fun getAccount(id: Long): Account {
        return loadAccountPort.loadAccount(id)
    }

    @Transactional
    suspend fun createAccount(name: String): Account {
        val account = Account(name)
        return saveAccountPort.saveAccount(account)
    }

    @Transactional
    suspend fun updateAccount(id: Long, name: String): Account {
        val account = loadAccountPort.loadAccount(id)
        account.name = name
        return saveAccountPort.saveAccount(account)
    }
}