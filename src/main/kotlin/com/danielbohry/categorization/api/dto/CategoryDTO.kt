package com.danielbohry.categorization.api.dto

class CategoryDTO {

    var id: String? = null
    var name: String? = null
    var type: String? = null
    var rules: List<RuleDTO>? = emptyList()

}