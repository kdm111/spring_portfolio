package com.example.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController {

    // rest controller이기 때문에 httml response body에 리턴한다.
    @GetMapping("/test")
    //== @RequestMapping(method = [RequestMethod.GET], name = "/test")
    // 이 외에도 postMappring과 PutMapping이 존재한다.
    fun test(): String {
        return "OK"
    }


}