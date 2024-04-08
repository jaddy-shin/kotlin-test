package me.jaddy.kotlin_webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWebfluxApplication

fun main(args: Array<String>) {
    runApplication<KotlinWebfluxApplication>(*args)
}
