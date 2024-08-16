package com.kotlin.issueservice.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(e: ServerException): ResponseEntity<ErrorResponse> {
        logger.error { e.message }

        return ResponseEntity(ErrorResponse(code = e.code, message = e.message), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidExceptionException(
        e: MethodArgumentNotValidException,
    ): ResponseEntity<ErrorResponse> {
        logger.error { e.message }

        return ResponseEntity(ErrorResponse(code = 400, message = "잘못된 요청입니다."), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(e: TokenExpiredException): ResponseEntity<ErrorResponse> {
        logger.error { e.message }

        return ResponseEntity(ErrorResponse(code = 401, message = "만료된 토큰입니다."), HttpStatus.UNAUTHORIZED)
    }
}
