package com.danielbohry.categorization.infrastructure

import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryRepo : MongoRepository<CategoryEntity, String>