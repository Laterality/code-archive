package kr.latera.tlsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyController {

    @GetMapping
    public String hello() {
        return "Hello, world!";
    }

    @PostMapping("/greet")
    public String greet(@RequestBody Map<String, String> params) {
        return "Hello, " + params.get("name");
    }
}
