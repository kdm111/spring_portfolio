package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

// jpa에서 인터페이스만 보고도 알아서 레포지토리를 만들어준다.
interface ExperienceRepository:JpaRepository<Experience, Long> {

    // 성능 최적화가 필요하다.
    fun findAllByIsActive(isActive: Boolean): List<Experience>


}