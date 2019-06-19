package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.CategoryDTO
import com.danielbohry.categorization.api.dto.RuleDTO
import com.danielbohry.categorization.business.CategoryService
import com.danielbohry.categorization.business.RuleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(
        val categoryService: CategoryService,
        val categoryConverter: CategoryConverter,
        val ruleService: RuleService,
        val ruleConverter: RuleConverter) {

    @GetMapping
    fun getAll() = categoryService.getAll()

    @PostMapping
    fun save(@RequestBody category: CategoryDTO) =
            categoryService.save(categoryConverter.toEntity(category))

    @GetMapping("/{category}/rules")
    fun getAllRules(@PathVariable category: String): ResponseEntity<List<RuleDTO>> =
            ResponseEntity.ok(ruleService.getAll().map { rule -> ruleConverter.toDTO(rule) })

}