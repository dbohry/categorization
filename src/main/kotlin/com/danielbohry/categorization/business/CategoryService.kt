package com.danielbohry.categorization.business

import com.danielbohry.categorization.infrastructure.CategoryRepo
import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import org.springframework.stereotype.Service

@Service
class CategoryService(val repo: CategoryRepo) {

    fun getAll(): List<CategoryEntity> {
        return repo.findAll()
    }

    fun save(category: CategoryEntity) {
        repo.save(category)
    }

}