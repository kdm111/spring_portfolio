package com.example.portfolio.presentation.controller

import com.example.portfolio.presentation.dto.IntroductionDTO
import com.example.portfolio.presentation.dto.LinkDTO
import com.example.portfolio.presentation.dto.ProjectDTO
import com.example.portfolio.presentation.dto.ResumeDTO
import com.example.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService

) {

    // rest controller이기 때문에 httml response body에 리턴한다.
    @GetMapping("/test")
    //== @RequestMapping(method = [RequestMethod.GET], name = "/test")
    // 이 외에도 postMappring과 PutMapping이 존재한다.
    fun test(): String {
        return "OK"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        // 중요한 작업들은 서비스에서 다 해준다.
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }


    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }
    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }

}