package com.girouard.springfilrouge;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringFilRougeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFilRougeApplication.class, args);

        System.out.println("Ouais Ouais Ouais");

    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
