package kr.latera.fbpush

import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PushController(
    private val fbApp: FirebaseApp
) {

  private val logger = LoggerFactory.getLogger(javaClass)

  @PostMapping("/send")
  fun sendPush(@RequestParam to: String) {
    logger.info("Send to {}", to)
    val message = Message.builder()
        .setNotification(Notification.builder().setBody("Hello world!").build())
        .setToken(to)
        .build()

    logger.info("{}", message.toString())
    FirebaseMessaging.getInstance(fbApp).send(message)
  }
}