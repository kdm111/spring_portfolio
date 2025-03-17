package com.example.portfolio.presentation.service

import com.example.portfolio.domain.entity.Introduction
import com.example.portfolio.domain.entity.Link
import com.example.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.math.exp

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    // lateinit 코틀린은 널을 허용하지 않지만 초기값을 넣어줄 수 없는 경우 초기화를 조금 늦춘다.
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductinos() {
        // given : 조건
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i%2 == 0)
            introductions.add(introduction)
        }
        // introductions.filter { it.isActive }
        val activeIntroductions = introductions.filter { introduction ->  introduction.isActive}

        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeIntroductions)
        // when : 동작
        val introductionDTOs = presentationService.getIntroductions()

        // then : 결과
        assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOs) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks() {
        // given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "$${i}", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }
        val activeLinks = links.filter { link ->
            link.isActive
        }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)

        // when 여기에서 문제가 있다고 파악할 수 있음
        val linkDTOs = presentationService.getLinks()

        // then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }
        assertThat(linkDTOs).hasSize(expectedSize)
        for (linkDTO in linkDTOs) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}