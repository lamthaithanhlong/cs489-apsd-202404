package edu.miu.ent.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank(message = "Address should not be empty")
        String address,
        String city,
        String state,
        String zip
) {
}
