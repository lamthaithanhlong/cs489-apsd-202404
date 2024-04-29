package edu.miu.ent.dto;

public record UserResponse(
        Integer userId,
        String firstName,
        String lastName,
        String email
) { }
