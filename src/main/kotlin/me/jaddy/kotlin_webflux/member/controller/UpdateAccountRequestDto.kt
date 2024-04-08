package me.jaddy.kotlin_webflux.member.controller

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

data class UpdateAccountRequestDto(
    @field:JsonProperty
    @NotBlank
    val name: String
)
