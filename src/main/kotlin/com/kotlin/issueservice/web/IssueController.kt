package com.kotlin.issueservice.web

import com.kotlin.issueservice.config.AuthUser
import com.kotlin.issueservice.model.IssueRequest
import com.kotlin.issueservice.service.IssueService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issue")
class IssueController(
    private val issueService: IssueService,
) {
    @PostMapping
    fun create(
        authUser: AuthUser,
        @RequestBody request: IssueRequest,
    ) = issueService.create(authUser.userId, request)

    @PutMapping("/{id}")
    fun edit(
        authUser: AuthUser,
        @PathVariable id: Long,
        @RequestBody request: IssueRequest,
    ) = issueService.edit(authUser.userId, id, request)
}
