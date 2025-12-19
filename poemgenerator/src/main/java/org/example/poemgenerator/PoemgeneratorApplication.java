package org.example.poemgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PoemgeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoemgeneratorApplication.class, args);
    }

}
