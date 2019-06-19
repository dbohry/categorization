package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.CategoryDTO
import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import org.springframework.stereotype.Component

@Component
class CategoryConverter(val ruleConverter: RuleConverter) {

    fun toEntity(dto: CategoryDTO): CategoryEntity {
        val entity = CategoryEntity()
        entity.name = dto.name
        entity.type = dto.type
        entity.rules = dto.rules?.map { ruleConverter.toEntity(it) }

        return entity
    }

    fun toDTO(entity: CategoryEntity?): CategoryDTO {
        val dto = CategoryDTO()

        dto.id = entity?.id
        dto.name = entity?.name
        dto.type = entity?.type
        dto.rules = entity?.rules?.map { ruleConverter.toDTO(it) }

        return dto
    }

}