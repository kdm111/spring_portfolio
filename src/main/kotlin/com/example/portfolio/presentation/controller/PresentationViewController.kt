package com.example.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

// Controller이므로 기본적으로 html을 리턴한다
@Controller
class PresentationViewController {
    // 경로를 찾아서 이 메소드와 매핑한다.
    @GetMapping("/test")

    fun test(): String {
        return "test" //test라는 html을 반환한다.
    }

}