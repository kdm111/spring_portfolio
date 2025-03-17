package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Experience
import com.example.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest // jpa 테스트를 위한 어노테이션
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 테스트를 클래스 레벨로 하여 실행해줌
class ExperienceRepositoryTest(
    @Autowired val experienceRepository: ExperienceRepository
) {
    // 데이터 initial 클래스는 별로 좋지 않은 방법

    val DATA_SIZE = 10

    // dummy entity를 만드는 private 메소드
    private fun createExperience(n: Int): Experience {
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명",
            startYear = 2024,
            startMonth = 9,
            endYear = 2024,
            endMonth = 9,
            isActive = true
        )

        val details = mutableListOf<ExperienceDetail>()
        for (i in 1..n) {// 1~n
            val experienceDetail = ExperienceDetail(content = "text${i}", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)
        return experience
    }

    @BeforeAll // 테스트 데이터 초기화
    fun beforeAll() {
        println("---- 데이터 초기화 이전 조회 시작 ----")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)
        println("---- 데이터 초기화 이전 조회 종료 ----")

        println("---- 테스트 데이터 초기화 시작 ----")
        val experiences = mutableListOf<Experience>()
        for (i in 1..DATA_SIZE) {
            val experience = createExperience(i)
            experiences.add(experience)
        }
        experienceRepository.saveAll(experiences)
        println("---- 테스트 데이터 초기화 종료 ----")
    }

    @Test
    fun testFindAll() {
        println("---- findAll 테스트 시작 ----")
        val experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)
        println("expereinces.size : ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("expereince.details.size : ${experience.details.size}")
        }
        println("---- findAll 테스트 종료 ----")
    }

    // 메서드에 따라 테스트 시
    @Test
    fun testFindAllByIsActive() {
        println("---- findAllByIsActive 테스트 시작 ----")
        val experiences = experienceRepository.findAllByIsActive(true) // 테스트 실패 검증
        assertThat(experiences).hasSize(DATA_SIZE)
        println("expereinces.size : ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            println("expereince.details.size : ${experience.details.size}")
        }
        println("---- findAl작ByIsActive 테스트 종료 ----")
    }


}
