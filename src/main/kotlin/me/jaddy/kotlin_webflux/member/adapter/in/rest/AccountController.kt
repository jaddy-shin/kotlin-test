package me.jaddy.kotlin_webflux.member.adapter.`in`.rest

import jakarta.validation.Valid
import me.jaddy.kotlin_webflux.member.adapter.`in`.rest.model.CreateAccountRequestDto
import me.jaddy.kotlin_webflux.member.adapter.`in`.rest.model.AccountResponseDto
import me.jaddy.kotlin_webflux.member.adapter.`in`.rest.model.UpdateAccountRequestDto
import me.jaddy.kotlin_webflux.member.application.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
class AccountController(
    private val accountService: AccountService,
) {

    @GetMapping("/api/account/{id}")
    suspend fun getAccount(@PathVariable id: Long): AccountResponseDto {
        val account = accountService.getAccount(id)
        return AccountResponseDto.from(account)
    }

    @PostMapping("/api/account")
    suspend fun createAccount(@RequestBody @Valid account: CreateAccountRequestDto): AccountResponseDto {
        val createAccount = accountService.createAccount(account.name)
        return AccountResponseDto.from(createAccount)
    }

    @PutMapping("/api/account/{id}")
    suspend fun updateAccount(@PathVariable id: Long, @RequestBody @Valid account: UpdateAccountRequestDto): AccountResponseDto {
        val updateAccount = accountService.updateAccount(id, account.name)
        return AccountResponseDto.from(updateAccount)
    }
}