package com.example.portfolio.presentation.repository

import com.example.portfolio.domain.entity.*
import com.example.portfolio.domain.repository.*
import org.springframework.stereotype.Repository
import java.security.PrivateKey

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,

    private val articleRepository: ArticleRepository
) {
    fun getActiveAchivements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperiences(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroductions(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }
    fun getActiveLinks(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }
    fun getActiveProjects(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }
    fun getActiveSkills(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

    fun getArticles(): List<Article> {
        return articleRepository.findAll()
    }
}