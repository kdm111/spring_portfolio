package com.example.portfolio.domain

import com.example.portfolio.domain.constant.SkillType
import com.example.portfolio.domain.entity.*
import com.example.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.time.LocalDate

//import org.springframework.stereotype.Controller

// 빈을 생성 뒤 스프링에서 관리한다. 의존성 주입을 받아 사용한댜.
@Component // 인스턴스로 만든 뒤 별도로 관리한다.
//@Controller //
//@Repository
@Profile(value = ["default"]) // spring을 쓰면서 빈으로 등록하는데 Profile이 default로만 사용할 때 bean으로 만들어서 등록해라
class DataInitializer(
    // 먼저 빈 생성을 한 뒤 생성자 내부에 빈을 만들어 준다. 여기에서 초기화가 진행된다.
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    @PostConstruct // 필요로 하는 빈은 사전에 초기화 되어 있고 빈을 사용하여 데이터 초기화를 진행
    fun initializeData() {
        // log를 쓰는 것을 더 추천한다.
        println("스프링이 실행되었습니다. 테스트 데이터를 초기화 합니다.")

        val achievements = mutableListOf<Achievement>(

            Achievement(
                title = "2022 catkao 해커톤 우수상",
                description = "desc",
                host = "katcao",
                achivedDate = LocalDate.now(), // LocalDate.of(2022, 1, 1)
                isActive = true

            ),
            Achievement(
                title = "2023 catkao 해커톤 우수상",
                description = "desc",
                host = "katcao",
                achivedDate = LocalDate.now(), // LocalDate.of(2022, 1, 1)
                isActive = true
            )
        )
        // jpa에 따라 지원 하는 메서드를 사용하여 삽입이 가능함
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction( content = "1",  isActive = true),
            Introduction( content = "2",  isActive = true),
            Introduction( content = "3",  isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "github", content = "1121", isActive = true),
            Link(name = "inflearn", content = "1121", isActive = true),
            Link(name = "velog", content = "1121", isActive = true)
        )
        linkRepository.saveAll(links)

        // details같은 걸 받을 수 있음
        val experience1 = Experience(
            title = "1",
            description = "12",
            startYear = 2024,
            startMonth = 22,
            endYear = 2023,
            endMonth = 8,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf<ExperienceDetail>(
                ExperienceDetail(content = "2", isActive = true),
                ExperienceDetail(content = "3", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "3",
            description = "32",
            startYear = 9999,
            startMonth = 22,
            endYear = 2023,
            endMonth = 8,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf<ExperienceDetail>(
                // cascade 이기 때문에 같이 insert가 같이 실행된다.
                ExperienceDetail(content = "2", isActive = true),
                ExperienceDetail(content = "3", isActive = true)
            )
        )

        experienceRepository.saveAll(mutableListOf<Experience>(experience1, experience2))
        val java = Skill(name = "java", type = SkillType.LANGUAGE.name, isActive = true)
        val js = Skill(name = "js", type = SkillType.LANGUAGE.name, isActive = true)

        skillRepository.saveAll(mutableListOf<Skill>(java,js))

        val project1 = Project(
            name = "prj1",
            description = "project1",
            startYear = 2022,
            startMonth = 9,
            endYear = 2023,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            mutableListOf<ProjectDetail>(
                ProjectDetail(
                    content = "123",
                    url = null,
                    isActive = true
                ),
                ProjectDetail(
                    content = "456",
                    url = null,
                    isActive = true
                )
            )
        )
        project1.skills.addAll(
            mutableListOf<ProjectSkill>(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = js)
            )
        )

        val project2 = Project(
            name = "prj2",
            description = "project2",
            startYear = 2022,
            startMonth = 9,
            endYear = 2023,
            endMonth = 12,
            isActive = true
        )
        project2.addDetails(
            mutableListOf<ProjectDetail>(
                ProjectDetail(
                    content = "project2",
                    url = null,
                    isActive = true
                ),
                ProjectDetail(
                    content = "456",
                    url = null,
                    isActive = true
                ),
                ProjectDetail(
                    content = "utl",
                    url = "http://github.com/kdm111",
                    isActive = true
                )
            )
        )
        project2.skills.addAll(
            mutableListOf<ProjectSkill>(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = js)
            )
        )
        projectRepository.saveAll(mutableListOf<Project>(project1, project2))
    }
}