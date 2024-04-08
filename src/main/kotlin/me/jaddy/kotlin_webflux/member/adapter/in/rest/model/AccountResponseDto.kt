package me.jaddy.kotlin_webflux.member.adapter.`in`.rest.model

import me.jaddy.kotlin_webflux.member.domain.Account

data class AccountResponseDto(
    val id: Long,
    val name: String,
) {

    companion object {
        fun from(account: Account): AccountResponseDto {
            return with(account) {
                requireNotNull(id) { "id is null" }
                AccountResponseDto(id = id, name = name)
            }
        }
    }

}