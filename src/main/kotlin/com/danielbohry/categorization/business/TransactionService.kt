package com.danielbohry.categorization.business

import com.danielbohry.categorization.infrastructure.TransactionRepo
import com.danielbohry.categorization.infrastructure.entities.TransactionEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(val repo: TransactionRepo) {

    fun getAll() = repo.findAll()

    fun get(id: String) : Optional<TransactionEntity> = repo.findById(id)

    fun save(transaction: TransactionEntity) = repo.save(transaction)

}