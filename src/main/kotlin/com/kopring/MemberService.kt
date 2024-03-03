package com.kopring

import com.kopring.dto.MemberDto
import com.kopring.entity.MemberEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    fun findMember(id : Long): MemberDto {
        val findMember = memberRepository.findById(id)
            .orElseThrow { throw IllegalArgumentException() }

        return MemberDto(findMember.id, findMember.name)
    }

    @Transactional
    fun updateMember(memberDto : MemberDto): MemberDto {

        if(memberDto.id == null) {
            throw IllegalArgumentException()
        }

        val findMember = memberRepository.findById(memberDto.id)
            .orElseThrow { throw IllegalArgumentException() }

        findMember.name = memberDto.name
        println(memberDto.name)
        return MemberDto(findMember.id, findMember.name)
    }

    @Transactional
    fun deleteMember(id: Long) {
        memberRepository.deleteById(id)
    }
}