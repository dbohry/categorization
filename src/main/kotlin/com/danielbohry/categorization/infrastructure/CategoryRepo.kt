package com.danielbohry.categorization.infrastructure

import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface CategoryRepo : MongoRepository<CategoryEntity, String> {

    fun findByName(name: String): Optional<CategoryEntity>

}