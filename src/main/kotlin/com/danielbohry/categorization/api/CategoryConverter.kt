package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.CategoryDTO
import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import org.springframework.stereotype.Component

@Component
class CategoryConverter(val ruleConverter: RuleConverter) {

    fun toEntity(dto: CategoryDTO): CategoryEntity {
        var entity = CategoryEntity()
        entity.name = dto.name
        entity.type = dto.type
        entity.rules = dto.rules?.map { ruleConverter.toEntity(it) }

        return entity
    }

}