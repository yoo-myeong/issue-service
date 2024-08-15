package com.kotlin.issueservice.domain.issue

import org.springframework.data.jpa.repository.JpaRepository

interface IssueRepository : JpaRepository<Issue, Long>
