package com.example.portfolio.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(
    // 클라이언트 정보를 꺼내옴
    httpServletRequest : HttpServletRequest
): BaseEntity() {

    @Id // id를 붙여야 이 필드가 pk라는 것을 알 수 있다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null  // 처음 엔터티를 생성할 때 부여되는 값

    // ?는 null이면 실행안되고 아니면 실행이 된다.
    var cookies: String? = httpServletRequest.cookies
            ?.map { "${it.name} : ${it.value}" }
            ?.toString()

    // 요청이 온 도메인 주소
    var referer: String? = httpServletRequest.getHeader("referer")

    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost
    // 서버에서 어떤 uri로 접속하였는지
    var requestUri: String? = httpServletRequest.requestURI
    // 사용자가 접속한 브라우저 혹은 화면 뷰
    var userAgent: String? = httpServletRequest.getHeader("user-agent")
}