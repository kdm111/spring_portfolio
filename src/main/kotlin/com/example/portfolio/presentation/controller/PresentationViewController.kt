package com.example.portfolio.presentation.controller

import com.example.portfolio.domain.constant.SkillType
import com.example.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

// Controller이므로 기본적으로 html을 리턴한다
@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {
    // 경로를 찾아서 이 메소드와 매핑한다.
    @GetMapping("/test")
    fun test(): String {
        return "test" //test라는 html을 반환한다.
    }

    @GetMapping("/")
    fun index(model:Model): String {
        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions", introductions)

        val links = presentationService.getLinks()
        model.addAttribute("links", links)

        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = presentationService.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projects = presentationService.getProjects()
        model.addAttribute("projects", projects)

        return "presentation/projects"
    }



}