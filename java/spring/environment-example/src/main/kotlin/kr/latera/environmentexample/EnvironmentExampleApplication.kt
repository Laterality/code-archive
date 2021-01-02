package kr.latera.environmentexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EnvironmentExampleApplication

fun main(args: Array<String>) {
	runApplication<EnvironmentExampleApplication>(*args)
}
