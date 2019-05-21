package com.danielbohry.categorization.api.dto

import com.danielbohry.categorization.infrastructure.entities.CategoryEntity
import java.math.BigDecimal
import java.time.LocalDate

class TransactionDTO {

    var id: String? = null
    var description: String? = null
    var sepaCode: String? = null
    var amount: BigDecimal? = null
    var date: LocalDate? = null
    var category: CategoryEntity? = null

}