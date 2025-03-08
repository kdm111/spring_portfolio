package com.example.portfolio.domain.entity

import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import jakarta.persistence.Column
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate
    // column 설정, null, update 불가
    @Column(nullable = false, updatable = false)
    var createdDateTime: LocalDateTime = LocalDateTime.now()
    
    @LastModifiedDate
    @Column(nullable = false, updatable = true)
    var updatedDateTime: LocalDateTime = LocalDateTime.now();
    
}
