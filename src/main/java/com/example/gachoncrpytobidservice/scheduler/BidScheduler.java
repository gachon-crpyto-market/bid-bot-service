package com.example.gachoncrpytobidservice.scheduler;

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

    @Scheduled(fixedDelay = 1000)
    public void bidScheduleTask() {
        System.out.println(bidService.getCurrentBidPrice());
    }


}
