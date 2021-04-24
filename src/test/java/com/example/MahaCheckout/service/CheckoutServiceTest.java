package com.example.MahaCheckout.service;

import com.example.MahaCheckout.model.CheckoutRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

class CheckoutServiceTest {

    CheckoutService checkoutService = new CheckoutService();

    @Test
    void calculatePrice3Rolex() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Arrays.asList("001", "001", "001"))
                                                 .build();

        assertEquals(200, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice6Rolex() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Arrays.asList("001", "001", "001", "001", "001", "001"))
                                                 .build();

        assertEquals(400, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice3Rolex2MichaelKors() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Arrays.asList("001", "001", "001", "002", "002"))
                                                 .build();

        assertEquals(320, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice9Rolex6MichaelKors() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Arrays.asList("001", "001", "001", "001", "001", "001", "001", "001", "001", "002", "002", "002", "002", "002", "002"))
                                                 .build();

        assertEquals(960, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice0() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Collections.emptyList())
                                                 .build();

        assertEquals(0, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice1Swatch() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Collections.singletonList("003"))
                                                 .build();

        assertEquals(50, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice1Casio() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Collections.singletonList("004"))
                                                 .build();

        assertEquals(30, checkoutService.calculatePrice(request).getPrice());
    }

    @Test
    void calculatePrice1Swatch1Casio() {
        CheckoutRequest request = CheckoutRequest.builder()
                                                 .watches(Arrays.asList("003", "004"))
                                                 .build();

        assertEquals(80, checkoutService.calculatePrice(request).getPrice());
    }

}