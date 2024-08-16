package com.kotlin.issueservice.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
) : RuntimeException(message)

data class NotFoundException(
    override val message: String,
) : ServerException(404, message)

data class UnauthorizedException(
    override val message: String = "인증정보가 잘못되었습니다.",
) : ServerException(401, message)

data class InvalidRequestException(
    override val message: String = "잘못된 요청입니다.",
) : ServerException(400, message)
