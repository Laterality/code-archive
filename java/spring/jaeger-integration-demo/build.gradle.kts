import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.3.0.RELEASE"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
  kotlin("jvm") version "1.3.72"
  kotlin("plugin.spring") version "1.3.72"
  kotlin("plugin.jpa") version "1.3.72"
}

val projects = listOf(
    project("greeter-api")
)

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

allprojects {
  repositories {
    mavenCentral()
  }
}

configure(projects) {
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-jpa")
  apply(plugin = "kotlin-kapt")
  apply(plugin = "kotlin-spring")

  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "org.springframework.boot")

  apply(plugin = "java-library")

  group = "kr.latera.greeter"
  version = "0.0.1-SNAPSHOT"
  java.sourceCompatibility = JavaVersion.VERSION_1_8

  tasks.withType<Test> {
    useJUnitPlatform()
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "1.8"
    }
  }

  repositories {
    mavenCentral()
  }
}
