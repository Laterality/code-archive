package kr.latera.fbpush

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource


@Configuration
class FirebaseAppConfiguration {

  @Bean
  fun app(): FirebaseApp {
    // JSON 스트림으로 인증에 필요한 정보를 import
    // 발송 앱이 여러개가 될 경우 어떻게 관리할지(DB, Env var, class path files, etc.)
    val serviceAccount = ClassPathResource("/test-push-app-5adb2-firebase-adminsdk-xvm5o-96432a8ff3.json").inputStream
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    return FirebaseApp.initializeApp(options)
  }
}