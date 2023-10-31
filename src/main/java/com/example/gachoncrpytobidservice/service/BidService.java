package com.example.gachoncrpytobidservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class BidService {
    private final StringRedisTemplate stringRedisTemplate;

    public int getCurrentBidPrice(){
        String currentBidPriceString = getCurrentBidPriceString();
        return Integer.parseInt(currentBidPriceString);
    }

    private String getCurrentBidPriceString(){
        return getKeysByPattern("*").stream()
                .max(String::compareTo)
                .get();
    }

    private Set<String> getKeysByPattern(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }
}
