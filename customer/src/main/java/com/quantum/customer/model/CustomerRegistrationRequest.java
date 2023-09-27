package com.quantum.customer.model;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
