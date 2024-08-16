package com.kotlin.issueservice.service

import com.kotlin.issueservice.domain.menber.Member
import com.kotlin.issueservice.domain.menber.MemberRepository
import com.kotlin.issueservice.web.dto.MemberDtoRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            return "이미 등록된 ID입니다."
        }

        member =
            Member(
                loginId = memberDtoRequest.loginId,
                password = memberDtoRequest.password,
                name = memberDtoRequest.name,
                birthDate = memberDtoRequest.birthDate,
                gender = memberDtoRequest.gender,
                email = memberDtoRequest.email,
            )

        memberRepository.save(member)

        return "회원가입 완료"
    }
}
