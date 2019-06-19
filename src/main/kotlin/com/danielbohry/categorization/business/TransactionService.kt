package com.danielbohry.categorization.business

import com.danielbohry.categorization.business.exception.ResourceNotFoundException
import com.danielbohry.categorization.infrastructure.TransactionRepo
import com.danielbohry.categorization.infrastructure.entities.TransactionEntity
import org.springframework.stereotype.Service

@Service
class TransactionService(val repo: TransactionRepo) {

    fun getAll() : List<TransactionEntity> = repo.findAll()

    fun get(id: String): TransactionEntity =
            repo.findById(id).orElseThrow { ResourceNotFoundException(notFoundMessage(id)) }

    fun save(transaction: TransactionEntity) = repo.save(transaction)

    fun update(id: String, transaction: TransactionEntity): TransactionEntity {
        return repo.findById(id).map {
            it.description = transaction.description
            it.sepaCode = transaction.sepaCode
            it.date = transaction.date
            it.amount = transaction.amount

            repo.save(it)
        }.orElseThrow { ResourceNotFoundException(notFoundMessage(id)) }
    }

    private fun notFoundMessage(id: String) : String {
        return "ID [$id] not found"
    }

}