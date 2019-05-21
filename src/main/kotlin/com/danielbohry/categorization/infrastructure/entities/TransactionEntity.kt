package com.danielbohry.categorization.infrastructure.entities

import org.springframework.data.annotation.Id
import java.math.BigDecimal
import java.time.LocalDate

class TransactionEntity {

    @Id
    var id: String? = null
    var description: String? = null
    var sepaCode: String? = null
    var amount: BigDecimal? = null
    var date: LocalDate? = null
    var category: CategoryEntity? = null

}