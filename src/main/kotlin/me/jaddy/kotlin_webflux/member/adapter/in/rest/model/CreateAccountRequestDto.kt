package me.jaddy.kotlin_webflux.member.adapter.`in`.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank

data class CreateAccountRequestDto(
    @field:JsonProperty
    @NotBlank
    val name: String
)
