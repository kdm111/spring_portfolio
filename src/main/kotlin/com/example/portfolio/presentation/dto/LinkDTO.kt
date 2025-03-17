package com.example.portfolio.presentation.dto

import com.example.portfolio.domain.entity.Link

data class LinkDTO (
    val name: String,
    val content: String
) {
    constructor(link: Link) :this (
        name = link.name.lowercase(), // 클라이언트에서 바꾸는 것보다 백엔드에서 바꾸는 것이 더 좋을 것이다.
        content = link.content
    )
}