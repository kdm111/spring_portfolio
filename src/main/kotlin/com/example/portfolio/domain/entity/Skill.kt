package com.example.portfolio.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import jakarta.persistence.Enumerated
import jakarta.persistence.EnumType
import com.example.portfolio.domain.constant.SkillType

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean
): BaseEntity() {

    @Id // id를 붙여야 이 필드가 pk라는 것을 알 수 있다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null  // 처음 엔터티를 생성할 때 부여되는 값

    var name: String = name

    // type 자체가 oracle에서는 예약어이다. 
    // 일반적인 단어는 컬럼명으로 사용되지 않는다.
    @Column(name = "skill_type")
    // EnumType의 디폴트 ORDINAL은 1,2,3 처럼 enum의 숫자로 들어가지만
    // 데이터 자체의 정합성이 깨질 일이 있거나 숫자로 인해 인식이 잘 되지 않기 때문에 
    // Stirng을 사용한다.
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

    // is_active로 알아서 매핑된다.
    var isActive: Boolean = isActive
}