package com.example.portfolio.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn

@Entity
class ProjectSkill(
    project: Project,
    skill: Skill
): BaseEntity() {

    @Id // id를 붙여야 이 필드가 pk라는 것을 알 수 있다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    var id: Long? = null  // 처음 엔터티를 생성할 때 부여되는 값

    @ManyToOne(
        targetEntity = Project::class,
        fetch = FetchType.LAZY,
    )
    @JoinColumn(name = "project_id", nullable = false)
    var project: Project = project

    @ManyToOne(
        targetEntity = Skill::class,
        fetch = FetchType.LAZY,
    )
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill

}