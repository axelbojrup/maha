package com.example.MahaCheckout.model;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", toBuilder = true)
public class CheckoutResponse {

    private final long price;

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}
