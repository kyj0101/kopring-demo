package com.kopring

import com.kopring.dto.MemberDto
import com.kopring.entity.MemberEntity
import org.springframework.stereotype.Service

@Service
class MemberService (
    private val memberRepository : MemberRepository
){

    fun createMember(name : String): MemberDto {

        val member = MemberEntity(name)
        memberRepository.save(member)

        return MemberDto(member.id, member.name);
    }

    fun findMemberList() : List<MemberDto> {

        val findAll = memberRepository.findAll()
        val memberList = ArrayList<MemberDto>()

        for (memberEntity in findAll) {
            memberList.add(MemberDto(memberEntity.id, memberEntity.name))
        }

        return memberList
    }
}