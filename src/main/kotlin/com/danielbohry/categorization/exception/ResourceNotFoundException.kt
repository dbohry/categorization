package com.danielbohry.categorization.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class ResourceNotFoundException(message: String) : RuntimeException(message)