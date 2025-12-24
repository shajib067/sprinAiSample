package com.tutor.booking.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @GetMapping("/me")
    public Map<String, String> me(
            @AuthenticationPrincipal UserDetails user
    ) {
        return Map.of("email", user.getUsername());
    }
}

