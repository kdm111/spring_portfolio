package com.example.portfolio.presentation.service

import com.example.portfolio.domain.entity.Link
import com.example.portfolio.presentation.dto.*
import com.example.portfolio.presentation.repository.PresentationRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private  val presentationRepository: PresentationRepository
) {
     // 함수 전체가 하나의 트랜잭션으로 묶인다.
    @Transactional(readOnly = true) // jpa가 조회할 때 스냅샷을 뜨게 되는데 스냅샷과 현재 엔터티와 변화를 통해 반영
     // readOnly의 경우에는 조회성으로만 되므로 스냅샷을 생략한다.
    fun getIntroductions():List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()
        return introductions.map { IntroductionDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getLinks():List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()
        return links.map { LinkDTO(it) }
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchivements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()

        return projects.map { ProjectDTO(it) }
    }

}