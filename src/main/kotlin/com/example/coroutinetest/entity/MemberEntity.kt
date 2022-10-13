package com.example.coroutinetest.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(value = "member")
data class MemberEntity (
        @Id var id: String? = null,
        var name: String? = null,
        var userId: String? = null,
        var userPw: String? = null){
}