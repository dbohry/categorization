package com.danielbohry.categorization.infrastructure

import com.danielbohry.categorization.infrastructure.entities.TransactionEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface TransactionRepo : MongoRepository<TransactionEntity, String>