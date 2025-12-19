package org.example.poemgenerator.controller;

import org.example.poemgenerator.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PoemController {

    @Autowired
    PoemService poemService;

    @GetMapping("/poem")
    public Mono<String> getPoem() {
        return poemService.generatePoem();
    }
}
