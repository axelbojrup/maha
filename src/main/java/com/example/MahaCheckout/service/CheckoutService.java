package com.example.MahaCheckout.service;

import com.example.MahaCheckout.domain.WatchEnum;
import com.example.MahaCheckout.model.CheckoutRequest;
import com.example.MahaCheckout.model.CheckoutResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.MahaCheckout.domain.WatchEnum.MICHAEL_KORS;
import static com.example.MahaCheckout.domain.WatchEnum.ROLEX;

@Service
public class CheckoutService {
    public CheckoutResponse calculatePrice(CheckoutRequest request) {

        List<WatchEnum> watches = request.getWatches()
                                         .stream()
                                         .map(WatchEnum::toDomain)
                                         .collect(Collectors.toList());

        long sum = watches.stream().mapToLong(WatchEnum::getUnitPrice).sum();

        long discount = calculateDiscount(watches);

        return CheckoutResponse.builder()
                               .price(sum - discount)
                               .build();
    }

    private long calculateDiscount(List<WatchEnum> watches) {
        int rolex_counter = 0;
        int michael_cors_counter = 0;
        for(WatchEnum watch : watches){
            if(watch.getId().equals(ROLEX.getId())){
                rolex_counter += 1;
            }
            if(watch.getId().equals(MICHAEL_KORS.getId())){
                michael_cors_counter += 1;
            }
        }
        return (rolex_counter / 3 * 100L) + (michael_cors_counter / 2 * 40L);

    }
}
