package com.kotlin.issueservice.web.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.kotlin.issueservice.common.ValidEnum
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class MemberDtoRequest(
    val id: Long?,
    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,
    @field:NotBlank
    @JsonProperty("password")
    @field:Pattern(
        regexp = "^(?=.*[a-zA-Z])(?=.*[!@#\$%^*+=-])(?=.*[0-9]).{8,15}\$",
        message = "영문, 숫자, 특수문자를 포함한 8자 이상",
    )
    private val _password: String?,
    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,
    @field:NotBlank
    @JsonProperty("birthDate")
    @field:Pattern(
        regexp = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])\$",
        message = "YYYY-MM-DD 형식",
    )
    private val _birthDate: String?,
    @field:NotBlank
    @JsonProperty("gender")
    @field:ValidEnum(enumClass = Gender::class, message = "MAN or WOMAN")
    private val _gender: String?,
    @field:NotBlank
    @JsonProperty("email")
    @field:Email
    private val _email: String?,
) {
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
    val name: String
        get() = _name!!
    val birthDate: LocalDate
        get() = _birthDate!!.toLocalDate()
    val gender: Gender
        get() = Gender.valueOf(_gender!!)
    val email: String
        get() = _email!!

    private fun String.toLocalDate(): LocalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
}
