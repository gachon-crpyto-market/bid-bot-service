package com.example.gachoncrpytobidservice.service;

import com.example.gachoncrpytobidservice.dto.request.BidRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class BidService {
    private final BidFeignClient bidFeignClient;
    private final StringRedisTemplate stringRedisTemplate;

    public int getCurrentBidPrice() {
        String currentBidPriceString = getCurrentBidPriceString();
        return Integer.parseInt(currentBidPriceString);
    }

    public String sendBotBidPrice(BidRequestDto bidRequestDto){
        return bidFeignClient.getBidFeignInfo(bidRequestDto);
    }

    private String getCurrentBidPriceString() {
        return getKeysByPattern("*").stream()
                .max(String::compareTo).orElse("950");
    }

    private Set<String> getKeysByPattern(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }
}
