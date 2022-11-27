package com.hj.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class RetryService {

    /**
     * 랜덤 숫자가 짝수가 나오면 IllegalStateException
     * 100ms 대기 후 2회 재시도
     *
     * @return
     */
    @Retryable(maxAttempts = 2, value= IllegalStateException.class, backoff = @Backoff(delay = 100))
    public int randomInt() {
        int rand = new Random().nextInt();
        if(rand % 2 == 0)
            throw new IllegalStateException("모두 짝수");

        return rand;
    }

    /**
     * 재시도 실패 시 호출
     *
     * @param ex
     * @return
     */
    @Recover
    public int recover(IllegalStateException ex) {
        log.error("recover : " + ex.getMessage());

        return 0;
    }

}
