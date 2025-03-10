package com.example.portfolio.domain.repository

import com.example.portfolio.domain.constant.SkillType
import com.example.portfolio.domain.entity.Introduction
import com.example.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

// jpa에서 인터페이스만 보고도 알아서 레포지토리를 만들어준다.
interface SkillRepository:JpaRepository<Skill, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Skill>


    // select * from skill where lower(name) = lower(:name) and skill_type = :type
    fun findByNameIgnoreCaseAndType(name: String, type:SkillType): Optional<Skill>


}