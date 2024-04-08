package me.jaddy.kotlin_webflux.member.adapter.out

import me.jaddy.kotlin_webflux.member.adapter.out.model.AccountPersistenceModel
import org.springframework.data.r2dbc.repository.R2dbcRepository


interface AccountRepository : R2dbcRepository<AccountPersistenceModel, Long>