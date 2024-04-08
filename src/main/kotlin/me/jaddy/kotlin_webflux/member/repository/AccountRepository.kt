package me.jaddy.kotlin_webflux.member.repository

import me.jaddy.kotlin_webflux.member.domain.Account
import org.springframework.data.r2dbc.repository.R2dbcRepository


interface AccountRepository : R2dbcRepository<Account, Long>