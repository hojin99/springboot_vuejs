package com.hj.study.task;

import com.hj.study.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@ConditionalOnExpression("${schedule.retry-task:true}")
@Component
public class RetryTask {

    private RetryService retryService;

    public RetryTask(RetryService service) {
        this.retryService = service;
    }

    @Scheduled(fixedDelay = 3000)
    public void randomInt() {
        try {
            log.info("random int : " + retryService.randomInt());
        } catch(Exception ex) {
            log.error("retry error : " + ex.getMessage());
        }

    }

}
