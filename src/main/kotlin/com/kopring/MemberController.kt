package com.kopring

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MemberController {


    @ResponseBody
    @GetMapping("/hello")
    fun hello(): String {
        return "퇴근.."
    }
}