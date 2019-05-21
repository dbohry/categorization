package com.danielbohry.categorization.infrastructure

import com.danielbohry.categorization.infrastructure.entities.RuleEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface RuleRepo : MongoRepository<RuleEntity, String>