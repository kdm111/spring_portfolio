package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.time.LocalDateTime

// jpa에서 인터페이스만 보고도 알아서 레포지토리를 만들어준다.
interface HttpInterfaceRepository:JpaRepository<HttpInterface, Long> {


    fun countAllByCreatedDateTimeBetween(start:LocalDateTime, end: LocalDateTime)
}