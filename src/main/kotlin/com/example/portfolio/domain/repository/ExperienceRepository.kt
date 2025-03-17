package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

// jpa에서 인터페이스만 보고도 알아서 레포지토리를 만들어준다.
interface ExperienceRepository:JpaRepository<Experience, Long> {

    // 성능 최적화가 필요하다.
    // java의 객체 지향적인 sql을 작성가능하다.
    @Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>

    @Query("select e from Experience e left join fetch e.details where e.id = :id")
    override fun findById(id: Long) :Optional<Experience>
}