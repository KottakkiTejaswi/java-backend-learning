package com.tejaswi.controller;

import com.tejaswi.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public HelloController() {
        System.out.println("HelloController bean created");
    }

    @GetMapping("/hello")
    public HelloResponseDto hello() {
        return new HelloResponseDto(
                "Hello from Spring Boot with DTO!",
                "Tejaswi"
        );
    }
}
