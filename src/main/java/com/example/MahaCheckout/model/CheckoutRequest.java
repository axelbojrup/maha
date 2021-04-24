package com.example.MahaCheckout.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;


@Value
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
@JsonDeserialize(builder = CheckoutRequest.Builder.class)
public class CheckoutRequest {

    private final List<String> watches;

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
    }
}