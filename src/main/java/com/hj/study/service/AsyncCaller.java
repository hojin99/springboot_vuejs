package com.hj.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class AsyncCaller {

    private final AsyncService service;

    private ConcurrentHashMap<String, ListenableFuture<String>> jobMap = new ConcurrentHashMap<>();

    public AsyncCaller(AsyncService service) {
        this.service = service;
    }

    public void addJob(String key) throws Exception {

        if(jobMap.get(key) != null) {
            log.warn(key + " job already existed");
            throw new Exception(key + " job already existed");
        }

        ListenableFuture<String> result = service.runJob(key);
        result.addCallback(
            (ret) -> {
                jobMap.remove(key);
                log.info("completed callback : " + ret);
            }, (err) -> {
                jobMap.remove(key);
                log.error("error callback : " + err.getMessage());
            });
        jobMap.put(key, result);
    }

    public void stopJob(String key) throws Exception {
        ListenableFuture<String> result = jobMap.get(key);
        if(result == null) {
            log.warn("no such job - " + key);
            throw new Exception("no such job - " + key);
        } else {
            log.info(key + " job will cancel");
        }

        result.cancel(true);
    }

}
