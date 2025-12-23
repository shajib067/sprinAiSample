package com.tutor.booking.dto;

public record SignupRequest(
        String email,
        String password,
        String fullName
) {}
