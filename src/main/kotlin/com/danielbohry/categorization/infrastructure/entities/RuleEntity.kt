package com.danielbohry.categorization.infrastructure.entities

import org.springframework.data.annotation.Id

class RuleEntity {

    @Id
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var syntaxe: String? = null

}