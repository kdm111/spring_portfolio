package com.example.portfolio.presentation.dto

import com.example.portfolio.domain.entity.Achievement
import com.example.portfolio.domain.entity.Experience
import com.example.portfolio.domain.entity.Skill
import java.time.format.DateTimeFormatter

class ResumeDTO (
    experiences: List<Experience>,
    achievements: List<Achievement>,
    skills: List<Skill>
) {
    var experiences: List<ExperienceDTO> = experiences.map {
        ExperienceDTO(
            title = it.title,
            description = it.description,
            startYearMonth = "${it.startYear}.${it.startMonth}",
            endYearMonth = it.getEndYearMonth(),
            // 필터링을 여기서 하는 이유는 조건을 간단하게 걸기 때문에 true false를 모두 가져오게 된다.
            details = it.details.filter {it.isActive}.map {it.content}

        )
    }

    var achievements: List<AchievementDTO> = achievements.map {
        AchievementDTO (
            title = it.title,
            description = it.description,
            host = it.host,
            achievedDate = it.achievedDate
                ?.format(DateTimeFormatter.ISO_LOCAL_DATE)
                ?.replace("-", ".")
        )
    }

    var skill: List<SkillDTO> = skills.map {SkillDTO(it)}
}