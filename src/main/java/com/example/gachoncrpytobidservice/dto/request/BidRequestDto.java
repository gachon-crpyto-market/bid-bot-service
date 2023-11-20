package com.example.gachoncrpytobidservice.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BidRequestDto {
    private String userId;
    private int price;
    private int quantity;

    public static BidRequestDto of(String userId, int price, int quantity){
        return BidRequestDto.builder()
                .userId(userId)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
