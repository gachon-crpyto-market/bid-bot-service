package com.example.gachoncrpytobidservice.service;

import com.example.gachoncrpytobidservice.dto.request.BidRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "bid-feign-client", url = "http://1.237.212.172:3000")
public interface BidFeignClient {
    @PostMapping("/order/bid")
    String getBidFeignInfo(BidRequestDto bidRequestDto);
}
