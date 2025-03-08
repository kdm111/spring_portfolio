package com.example.portfolio.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column

@Entity
class Introduction(
    content: String,
    isActive: Boolean
): BaseEntity() {

    @Id // id를 붙여야 이 필드가 pk라는 것을 알 수 있다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "introduction_id")
    var id: Long? = null  // 처음 엔터티를 생성할 때 부여되는 값
    
    var content: String = content

    var isActive: Boolean = isActive
}