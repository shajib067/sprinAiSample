package org.example.poemgenerator.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class PoemService {

    private final ChatClient chatClient;

    @Autowired
    public PoemService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public Mono<String> generatePoem() {
        String prompt = "Generate a short poem about Spring Boot and AI.";
        return Mono.fromCallable(() -> this.chatClient
                        .prompt(prompt)
                        .call()
                        .content())
                .subscribeOn(Schedulers.boundedElastic());  // ✅ runs off event loop
    }
}
