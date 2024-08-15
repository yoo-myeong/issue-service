package com.kotlin.issueservice.domain.issue

import com.kotlin.issueservice.domain.BaseEntity
import com.kotlin.issueservice.domain.issue.enums.IssuePriority
import com.kotlin.issueservice.domain.issue.enums.IssueStatus
import com.kotlin.issueservice.domain.issue.enums.IssueType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "issue")
class Issue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column var userId: Long,
    @Column var summary: String,
    @Column var description: String,
    @Enumerated(EnumType.STRING)
    @Column
    var type: IssueType,
    @Column
    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,
    @Column
    @Enumerated(EnumType.STRING)
    var status: IssueStatus,
) : BaseEntity()
