package com.girouard.springfilrouge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping({"/", "/hello"})
    public String sayHello() {
        return "<h1>Le serveur n'a pas explosé</h1>";
    }
}
