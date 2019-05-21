package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.RuleDTO
import com.danielbohry.categorization.business.RuleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/rules")
class RuleController(val service: RuleService, val converter: RuleConverter) {

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<RuleDTO>> =
            ResponseEntity.ok(service.getAll().map { rule -> converter.toDTO(rule) })

}