package com.hj.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    @Async
    public ListenableFuture<String> runJob(String key) throws Exception {

        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(1000);
                log.info(key + " running: " + i);
            }

            log.info(key + " job is completed");

        } catch(InterruptedException e) {
            log.error(key + " job is interrupted - " +e.getMessage());
        }

        return new AsyncResult<>("OK");
    }

}
