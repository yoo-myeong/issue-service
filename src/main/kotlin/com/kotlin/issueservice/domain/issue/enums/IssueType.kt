package com.kotlin.issueservice.domain.issue.enums

enum class IssueType {
    BUG,
    TASK,
    ;

    companion object {
        operator fun invoke(type: String) = valueOf(type.uppercase())
    }
}
