package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

// jpa에서 인터페이스만 보고도 알아서 레포지토리를 만들어준다.
interface ProjectRepository:JpaRepository<Project, Long> {

    // 다대일의 관계는 이렇게 쓰면 성능에 치명적이다.
    // project - skills, details
    // skills
    @Query("select p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    // findById는 오버라이드 해야 한다.
    @Query("select p from Project p left join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>
}