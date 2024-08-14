package com.kotlin.issueservice.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(e: ServerException): ErrorResponse {
        logger.error { e.message }

        return ErrorResponse(code = e.code, message = e.message)
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(e: ServerException): ErrorResponse {
        logger.error { e.message }

        return ErrorResponse(code = 401, message = "Token Expired!")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: ServerException): ErrorResponse {
        logger.error { e.message }

        return ErrorResponse(code = 500, message = "Internal Server Error")
    }
}
