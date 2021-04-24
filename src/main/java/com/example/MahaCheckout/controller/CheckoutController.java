package com.example.MahaCheckout.controller;

import com.example.MahaCheckout.model.CheckoutRequest;
import com.example.MahaCheckout.model.CheckoutResponse;
import com.example.MahaCheckout.service.CheckoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @RequestMapping(value = "/checkout", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE}, method = POST)
    public ResponseEntity<CheckoutResponse> checkout(@RequestBody CheckoutRequest request){
        CheckoutResponse response = checkoutService.calculatePrice(request);
        return ResponseEntity.ok(response);
    }
}
