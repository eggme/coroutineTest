package com.example.coroutinetest.handler

import com.example.coroutinetest.entity.MemberEntity
import com.example.coroutinetest.repository.MemberRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux

@Component
class MemberHandler {

    @Autowired lateinit var memberRepository: MemberRepository
    @Autowired lateinit var modelMapper: ModelMapper

    private val logger = LoggerFactory.getLogger(MemberHandler::class.java)

    suspend fun saveAndFindAll(): Flux<ServerResponse>{
        val member = MemberEntity(name = "최승준", userId = "movv104", userPw = "1234")
            memberRepository.save(member).subscribe{
                CoroutineScope(Dispatchers.Default).launch {
                    val logging = CoroutineScope(Dispatchers.Default).launch {
                        logger.info("member -> {}", modelMapper.map(it, MemberEntity::class.java))
                    }

                    logging.join()
                }
            }
            val mapper = memberRepository.findAll()

        return mapper.flatMap { ok().body(it, MemberEntity::class.java) }
    }
}