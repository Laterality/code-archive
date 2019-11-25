package kr.latera.corsmapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MyController {

    @GetMapping("/admin")
    private void doSomeForAdmin() {
        Map<String, String> response = new HashMap<>();
        response.put("result", "ok");
    }
}
