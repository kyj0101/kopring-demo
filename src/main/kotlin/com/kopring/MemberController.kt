package com.kopring

import com.kopring.dto.MemberDto
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MemberController (
    private val memberService : MemberService
){

    @ResponseBody
    @PostMapping("/members")
    fun createMember(@RequestParam name : String) : MemberDto {
        return memberService.createMember(name)
    }

    @ResponseBody
    @GetMapping("/members")
    fun getMemberList() : List<MemberDto> {
        return memberService.findMemberList()
    }

    @ResponseBody
    @GetMapping("/members/{id}")
    fun getMember(@PathVariable("id") id : Long) : MemberDto {
        return memberService.findMember(id)
    }

    @ResponseBody
    @PutMapping("/members")
    fun updateMember(@RequestBody memberDto : MemberDto) : MemberDto {
        return memberService.updateMember(memberDto)
    }

    @ResponseBody
    @DeleteMapping("/members/{id}")
    fun deleteMember(@PathVariable("id") id : Long) {
        memberService.deleteMember(id)
    }

}