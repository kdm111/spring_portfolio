package com.example.portfolio.presentation.dto

// 엔터티를 클라이언트에 전달하는 것은 좋은 방법이 아니다.
// db에는 굉장히 많은 컬럼이 존재하여 네트워크 부하가 더 크다.
// 보안적인 이슈가 존재할 수 있다.
// 전달하고자 하는 데이터만 보내서 담아 간다.
// jpa는 opensession view로 개발자가 의도하지 않은 방식으로 데이터가 수정될수 있기 때문에
// dto와 entity를 구분하여 작성한다.
// data 클래스는 dto만을 위한 객체이다.
// data toString 은 키 밸류 쌍으로 문자열로 전달한다.
data class AchievementDTO (
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String?
)