package ch.tbz.m321.servicea;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> hello() {
        return Map.of("message", "Hello World from Service A");
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "service-a");
    }
}
