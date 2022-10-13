package com.example.coroutinetest.config

import com.mongodb.reactivestreams.client.MongoClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.core.convert.MongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(basePackages = ["com.example.coroutinetest"], reactiveMongoTemplateRef = "defaultMongoTemplate")
class MongoTemplate {

    @Bean
    fun defaultReactiveMongoTemplate(mongoClient: MongoClient): SimpleReactiveMongoDatabaseFactory {
        return SimpleReactiveMongoDatabaseFactory(mongoClient, "test")
    }

    @Bean
    fun defaultMongoTemplate(@Qualifier("defaultReactiveMongoTemplate") factory: ReactiveMongoDatabaseFactory, converter: MongoConverter): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(factory, converter)
    }
}