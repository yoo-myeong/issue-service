package com.kotlin.issueservice.domain.menber

import com.kotlin.issueservice.web.dto.Gender
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.time.LocalDate

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false, length = 30, updatable = false)
    val loginId: String,
    @Column(nullable = false, length = 100)
    val password: String,
    @Column(nullable = false, length = 10)
    val name: String,
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    val birthDate: LocalDate,
    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    val gender: Gender,
    @Column(nullable = false, length = 30)
    val email: String,
)
