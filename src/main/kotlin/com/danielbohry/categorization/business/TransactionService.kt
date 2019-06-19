package com.danielbohry.categorization.business

import com.danielbohry.categorization.business.exception.ResourceNotFoundException
import com.danielbohry.categorization.infrastructure.TransactionRepo
import com.danielbohry.categorization.infrastructure.entities.TransactionEntity
import org.springframework.stereotype.Service

@Service
class TransactionService(val repo: TransactionRepo, val categoryService: CategoryService) {

    fun getAll(): List<TransactionEntity> = repo.findAll()

    fun get(id: String): TransactionEntity {
        val transaction = repo.findById(id).orElseThrow { ResourceNotFoundException(notFoundMessage(id)) }

        val category = transaction.category?.name

        transaction.category = categoryService.getByName(category.orEmpty()).orElse(null)

        return transaction
    }

    fun save(transaction: TransactionEntity) = repo.save(transaction)

    fun update(id: String, transaction: TransactionEntity): TransactionEntity {
        return repo.findById(id).map {
            it.description = transaction.description
            it.sepaCode = transaction.sepaCode
            it.date = transaction.date
            it.amount = transaction.amount
            it.category = transaction.category

            val category = transaction.category?.name.orEmpty()

            it.category = categoryService.getByName(category).orElse(null)

            repo.save(it)
        }.orElseThrow { ResourceNotFoundException(notFoundMessage(id)) }
    }

    private fun notFoundMessage(id: String): String = "ID [$id] not found"

}