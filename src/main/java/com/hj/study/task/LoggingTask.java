package com.hj.study.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled 어노테이션을 통한 스케쥴링
 * ScheduledTaskRegistrar에 등록 된 스케쥴러를 통해서 스케쥴링
 * 필요 시 Pool Size 등 조정
 *
 */
@Slf4j
@Component
@ConditionalOnExpression("${schedule.logging-task:true}")
public class LoggingTask
{
    /**
     * 작업 완료 후 fixedDelay 대기 후 실행
     */
    @Scheduled(initialDelay = 1000, fixedDelay = 10000)
    public void log1() {
        log.info("Scheduled - initialDelay + fixedDelay");
    }

    /**
     * fixedRate 간격으로 작업 실행 (이전 작업 완료까지 대기)
     */
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void log2() {
        log.info("Scheduled - initialDelay + fixedRate");
    }

    /**
     * cron 스케쥴 형태로 실행
     */
    @Scheduled(cron="10 * * * * *")
    public void log3() {
        log.info("Scheduled - cron");
    }
}
