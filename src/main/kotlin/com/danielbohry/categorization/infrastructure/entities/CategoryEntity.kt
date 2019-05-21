package com.danielbohry.categorization.infrastructure.entities

import org.springframework.data.annotation.Id

class CategoryEntity {

    @Id
    var id: String? = null
    var name: String? = null
    var type: String? = null

}