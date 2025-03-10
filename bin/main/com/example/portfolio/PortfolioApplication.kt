package com.example.portfolio

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PortfolioApplication
fun main(args: Array<String>) {
	// [미션1] 깃허브 리포지토리에 프로젝트 올리기
	runApplication<PortfolioApplication>(*args)
}
