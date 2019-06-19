package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.RuleDTO
import com.danielbohry.categorization.infrastructure.entities.RuleEntity
import org.springframework.stereotype.Component

@Component
class RuleConverter {

    fun toDTO(entity: RuleEntity): RuleDTO {
        var dto = RuleDTO()

        dto.id = entity.id
        dto.name = entity.name
        dto.description = entity.description
        dto.syntaxe = entity.syntaxe

        return dto
    }

    fun toEntity(dto : RuleDTO) : RuleEntity {
        var entity = RuleEntity()

        entity.description = dto.description
        entity.name = dto.name
        entity.syntaxe = dto.syntaxe

        return entity
    }

}