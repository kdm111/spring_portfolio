package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

// jpa에서 인터페이스만 보고도 알아서 레포지토리를 만들어준다.
interface ProjectRepository:JpaRepository<Project, Long> {
    
}