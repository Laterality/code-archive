package kr.latera.ssedemo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class SseController {

    private final SubscriptionService service;

    public SseController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseBodyEmitter subscribeEvent() {
        SseEmitter emitter = new SseEmitter();
        service.subscribe(emitter);
        return emitter;
    }

    @PostMapping("/send")
    public ResponseEntity sendMessage(@RequestBody String message) {
        service.broadcast(message);
        return ResponseEntity.created(null).build();
    }

}
