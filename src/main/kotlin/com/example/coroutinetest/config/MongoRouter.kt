package com.example.coroutinetest.config

import com.example.coroutinetest.handler.MemberHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class MongoRouter {

    @Bean
    fun findAllMembers(memberHandler: MemberHandler): RouterFunction<ServerResponse> {
        TODO()
    }
}