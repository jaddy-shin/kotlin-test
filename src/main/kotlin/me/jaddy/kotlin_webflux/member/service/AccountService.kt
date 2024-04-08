package me.jaddy.kotlin_webflux.member.service

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import me.jaddy.kotlin_webflux.member.domain.Account
import me.jaddy.kotlin_webflux.member.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService(
    private val accountRepository: AccountRepository,
) {

    @Transactional(readOnly = true)
    suspend fun getAccount(id: Long): Account {
        return accountRepository.findById(id).awaitSingleOrNull() ?: throw IllegalStateException("찾을 수 없습니다.")
    }

    @Transactional
    suspend fun createAccount(name: String): Account {
        val account = Account(name)
        return accountRepository.save(account).awaitSingle()
    }

    @Transactional
    suspend fun updateAccount(id: Long, name: String): Account {
        val account = getAccount(id)
        account.name = name
        return accountRepository.save(account).awaitSingle()
    }
}