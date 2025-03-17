package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article, Long> {

    // 제목이 정확하게 일치하는 아티클 조회
    fun findByTitle(title: String): List<Article>
}