package me.jaddy.kotlin_webflux.member.adapter.out.model

import me.jaddy.kotlin_webflux.member.domain.Account
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "accounts")
data class AccountPersistenceModel(
    @Id
    val id: Long?,
    val name: String,
    val teamId: Long?,
) {

    fun toDomain(): Account {
        return Account(id, name, teamId)
    }

    companion object {
        fun from(account: Account): AccountPersistenceModel = with(account) {
            return AccountPersistenceModel(id, name, teamId)
        }
    }
}
