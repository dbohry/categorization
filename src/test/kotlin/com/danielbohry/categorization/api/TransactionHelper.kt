package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.TransactionDTO
import com.danielbohry.categorization.infrastructure.TransactionRepo
import com.danielbohry.categorization.infrastructure.entities.TransactionEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.time.LocalDate

@Component
class TransactionHelper {

    @Autowired
    lateinit var repo: TransactionRepo

    fun deleteAll() = repo.deleteAll()

    fun createTransaction(): String? {
        val saved = repo.save(buildTransactionEntity())
        return saved.id
    }

    fun buildTransactionEntity(): TransactionEntity {
        val entity = TransactionEntity()

        entity.description = "description"
        entity.date = LocalDate.now()
        entity.amount = BigDecimal.ONE

        return entity
    }

    fun buildTransactionDTO(args: TransactionDTO?): TransactionDTO {
        val dto = TransactionDTO()

        dto.description = args?.description ?: "description"
        dto.date = args?.date ?: LocalDate.now()
        dto.amount = args?.amount ?: BigDecimal.ONE

        return dto
    }

}