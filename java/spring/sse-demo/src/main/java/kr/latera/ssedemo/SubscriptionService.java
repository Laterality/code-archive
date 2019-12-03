package kr.latera.ssedemo;

import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class SubscriptionService {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);

    private final Set<ResponseBodyEmitter> subscriptions;

    public SubscriptionService() {
        this.subscriptions = new HashSet<>();
    }

    public void subscribe(ResponseBodyEmitter emitter) {
        subscriptions.add(emitter);
        emitter.onCompletion(() -> {
            logger.info("emitter complete");
            subscriptions.remove(emitter);
        });
        emitter.onTimeout(() -> {
            logger.info("emitter timeout");
            subscriptions.remove(emitter);
        });
        logger.info("subscribed, total: {}", subscriptions.size());
    }

    public void broadcast(String message) {
        subscriptions.forEach(e -> trySendMessage(e, message));
    }

    private void trySendMessage(ResponseBodyEmitter emitter, String message) {
        try {
            emitter.send(message);
        } catch (ClientAbortException e) {
            subscriptions.remove(emitter);
            logger.info("Client disconnected, remains: {}", subscriptions.size());
        } catch (IOException e) {
            logger.error("Error while send message", e);
        }
    }
}
