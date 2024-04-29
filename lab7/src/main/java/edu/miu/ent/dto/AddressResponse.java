package edu.miu.ent.dto;

public record AddressResponse(
        Integer addressId,
        String address,
        String city,
        String state,
        String zip
) {
}
