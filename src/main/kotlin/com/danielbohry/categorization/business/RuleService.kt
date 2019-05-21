package com.danielbohry.categorization.business

import com.danielbohry.categorization.infrastructure.RuleRepo
import com.danielbohry.categorization.infrastructure.entities.RuleEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class RuleService(val repo: RuleRepo) {

    fun getAll() = repo.findAll()

    fun get(id: String) : Optional<RuleEntity> = repo.findById(id)

    fun save(transaction: RuleEntity) = repo.save(transaction)

}