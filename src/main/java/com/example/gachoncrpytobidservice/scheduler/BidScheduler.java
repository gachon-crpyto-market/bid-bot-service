package com.example.gachoncrpytobidservice.scheduler;

import com.example.gachoncrpytobidservice.dto.request.BidRequestDto;
import com.example.gachoncrpytobidservice.service.BidFeignClient;
import com.example.gachoncrpytobidservice.service.BidService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableAsync
@EnableScheduling
public class BidScheduler {
    private final BidService bidService;
    private final static int BOT_QUANTITY = 5;
    private final static String BOT_ID = "bid_bot";

    @Scheduled(fixedDelay = 1000)
    public void bidScheduleTask() {
        int currentBid = bidService.getCurrentBidPrice();
        BidRequestDto bidRequestDto = BidRequestDto.of(BOT_ID, currentBid, BOT_QUANTITY);
        String currentBotBid = bidService.sendBotBidPrice(bidRequestDto);
        System.out.println(currentBotBid);
    }
}
