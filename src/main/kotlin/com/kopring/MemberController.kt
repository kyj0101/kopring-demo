package com.kopring

import com.kopring.dto.MemberDto
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MemberController (
    private val memberService : MemberService
){

    @ResponseBody
    @PostMapping("/member")
    fun createMember(@RequestParam name : String) : MemberDto {
        return memberService.createMember(name)
    }
}