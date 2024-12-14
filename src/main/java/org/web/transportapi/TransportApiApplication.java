package org.web.transportapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TransportApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportApiApplication.class, args);
    }
}
@RestController
class HelloController {

    @GetMapping("/")
    public String home() {
        return "TEST TEST COMMIT2";
    }
}