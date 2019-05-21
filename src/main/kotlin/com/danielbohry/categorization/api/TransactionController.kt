package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.TransactionDTO
import com.danielbohry.categorization.business.TransactionService
import com.danielbohry.categorization.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(val service: TransactionService, val converter: TransactionConverter) {

    @GetMapping("/")
    fun getAll(): ResponseEntity<List<TransactionDTO>> {
        return ResponseEntity.ok(
                service.getAll()
                        .map { transaction -> converter.toDTO(transaction) }
        )
    }

    @GetMapping("{id}")
    fun get(@PathVariable("id") id: String): ResponseEntity<TransactionDTO> {
        return service.get(id)
                .map { transaction -> ResponseEntity.ok(converter.toDTO(transaction)) }
                .orElseThrow { ResourceNotFoundException("ID [$id] not found") }
    }

    @PostMapping
    fun save(@RequestBody dto: TransactionDTO): ResponseEntity<Void> {
        service.save(converter.toBO(dto))
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}