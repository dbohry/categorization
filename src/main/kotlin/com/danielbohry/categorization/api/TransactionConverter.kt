package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.TransactionDTO
import com.danielbohry.categorization.infrastructure.entities.TransactionEntity
import org.springframework.stereotype.Component

@Component
class TransactionConverter {

    fun toDTO(entity: TransactionEntity) : TransactionDTO {
        val dto = TransactionDTO()

        dto.id = entity.id
        dto.description = entity.description
        dto.amount = entity.amount
        dto.date = entity.date
        dto.sepaCode = entity.sepaCode
        dto.category = entity.category

        return dto
    }

    fun toBO(dto: TransactionDTO) : TransactionEntity {
        val entity = TransactionEntity()

        entity.description = dto.description
        entity.amount = dto.amount
        entity.date = dto.date
        entity.sepaCode = dto.sepaCode
        entity.category = dto.category

        return entity
    }

}