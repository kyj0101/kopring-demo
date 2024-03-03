package com.kopring

import com.kopring.dto.MemberDto
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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

}