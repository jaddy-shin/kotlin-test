package me.jaddy.kotlin_webflux.member.adapter.out

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import me.jaddy.kotlin_webflux.member.adapter.out.model.AccountPersistenceModel
import me.jaddy.kotlin_webflux.member.application.port.out.LoadAccountPort
import me.jaddy.kotlin_webflux.member.application.port.out.SaveAccountPort
import me.jaddy.kotlin_webflux.member.domain.Account
import org.springframework.stereotype.Component

@Component
class AccountAdapter(
    private val accountRepository: AccountRepository,
) : LoadAccountPort, SaveAccountPort {

    override suspend fun loadAccountOrNull(id: Long): Account? {
        return accountRepository.findById(id).awaitSingleOrNull()?.toDomain()
    }

    override suspend fun loadAccount(id: Long): Account {
        return loadAccountOrNull(id = id) ?: throw IllegalStateException("찾을 수 없습니다.")
    }

    override suspend fun saveAccount(account: Account): Account {
        val accountPersistenceModel = AccountPersistenceModel.from(account)
        val savedAccount = accountRepository.save(accountPersistenceModel).awaitSingle()
        return savedAccount.toDomain()
    }
}