package com.example.portfolio.presentation.dto

import com.example.portfolio.domain.entity.Article
import java.time.LocalDateTime

data class ArticleDTO(
    val title: String,
    val content: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    constructor(article: Article) : this(
        title = article.title,
        content = article.content,
        createdAt = article.createdAt,
        updatedAt = article.updatedAt
    )
}