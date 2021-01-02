package kr.latera.environmentexample

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfiguration(
    @Value("\${foo.bar}") someValue: String
) {
  private val logger = LoggerFactory.getLogger(javaClass)
  init {
    logger.info("someValue: {}", someValue)
  }
}