package com.zlate87.helloWorld.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class HelloWorldController {

    @GetMapping
    fun helloWorld():String {
        return "Hello from Spring Boot, Docker and Raspberry Pi"
    }
}