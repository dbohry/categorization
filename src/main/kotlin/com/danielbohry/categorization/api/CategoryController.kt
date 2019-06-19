package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.CategoryDTO
import com.danielbohry.categorization.api.dto.RuleDTO
import com.danielbohry.categorization.business.CategoryService
import com.danielbohry.categorization.business.exception.ResourceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.String.format

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(
        val service: CategoryService,
        val categoryConverter: CategoryConverter,
        val ruleConverter: RuleConverter) {

    @GetMapping
    fun getAll() = service.getAll()

    @PostMapping
    fun save(@RequestBody category: CategoryDTO) =
            service.save(categoryConverter.toEntity(category))

    @GetMapping("/{category}")
    fun getByName(@PathVariable category: String): ResponseEntity<CategoryDTO> {
        val result = service.getByName(category).orElseThrow {
            ResourceNotFoundException(format("Category %s not found", category))
        }

        return ResponseEntity.ok(categoryConverter.toDTO(result))
    }

    @GetMapping("/{category}/rules")
    fun getRulesFromCategory(@PathVariable category: String): ResponseEntity<List<RuleDTO>> {
        val result = service.getByName(category).orElseThrow {
            ResourceNotFoundException(format("Category %s not found", category))
        }

        return ResponseEntity.ok(result.rules?.map { it -> ruleConverter.toDTO(it) }.orEmpty())
    }

}