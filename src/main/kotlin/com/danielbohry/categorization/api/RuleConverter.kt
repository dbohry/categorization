package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.RuleDTO
import com.danielbohry.categorization.infrastructure.entities.RuleEntity
import org.springframework.stereotype.Component

@Component
class RuleConverter {

    fun toDTO(entity: RuleEntity): RuleDTO {
        val dto = RuleDTO()

        dto.name = entity.name
        dto.description = entity.description
        dto.syntaxe = entity.syntaxe

        return dto
    }

    fun toEntity(dto : RuleDTO) : RuleEntity {
        val entity = RuleEntity()

        entity.description = dto.description
        entity.name = dto.name
        entity.syntaxe = dto.syntaxe

        return entity
    }

}