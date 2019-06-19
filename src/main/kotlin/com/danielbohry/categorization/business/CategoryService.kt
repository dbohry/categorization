package com.danielbohry.categorization.business

import com.danielbohry.categorization.infrastructure.CategoryRepo
import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(val repo: CategoryRepo) {

    fun getAll(): List<CategoryEntity> = repo.findAll()

    fun getByName(name: String): Optional<CategoryEntity> = repo.findByName(name)

    fun save(category: CategoryEntity) = repo.save(category)

}