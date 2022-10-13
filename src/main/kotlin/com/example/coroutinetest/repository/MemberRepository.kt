package com.example.coroutinetest.repository

import com.example.coroutinetest.entity.MemberEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface MemberRepository: ReactiveMongoRepository<MemberEntity, String> {
//    fun findAllMember(): Flux<MemberEntity>

    fun findAllByName(name: String): Flux<MemberEntity>
}