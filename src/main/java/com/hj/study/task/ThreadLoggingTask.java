package com.hj.study.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@ConditionalOnExpression("${schedule.self-logging-task:true}")
public class ThreadLoggingTask {

    private ThreadPoolTaskScheduler scheduler;

    @PostConstruct
    public void init() {
        startScheduler();
    }

    /**
     * 직접 ThreadPoolTaskScheduler를 생성해서 스케쥴링
     *
     */
    private void startScheduler() {
        scheduler = new ThreadPoolTaskScheduler();
        scheduler.initialize();
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("ThreadPoolTaskScheduler called!");
            }
        }, new CronTrigger("20 * * * * *"));

    }

}
