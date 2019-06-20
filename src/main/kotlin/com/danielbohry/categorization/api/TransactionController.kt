package com.danielbohry.categorization.api

import com.danielbohry.categorization.api.dto.TransactionDTO
import com.danielbohry.categorization.business.TransactionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/transactions")
class TransactionController(val service: TransactionService, val converter: TransactionConverter) {

    @GetMapping
    fun getAll(): ResponseEntity<List<TransactionDTO>> {
        return ResponseEntity.ok(
                service.getAll()
                        .map { transaction -> converter.toDTO(transaction) }
        )
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: String): ResponseEntity<TransactionDTO> {
        val response = service.get(id)
        return ResponseEntity.ok(converter.toDTO(response))
    }

    @PostMapping
    fun save(@RequestBody dto: TransactionDTO): ResponseEntity<Void> {
        service.save(converter.toBO(dto))
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody dto: TransactionDTO): ResponseEntity<TransactionDTO> {
        val response = service.update(id, converter.toBO(dto))
        return ResponseEntity.ok(converter.toDTO(response))
    }

}