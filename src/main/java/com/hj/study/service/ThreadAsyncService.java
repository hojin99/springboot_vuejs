package com.hj.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Slf4j
@Service
public class ThreadAsyncService {

    private ThreadPoolTaskExecutor executor;

    // 작업 목록
    private HashMap<String, JobRunnable> jobMap = new HashMap<>();

    public ThreadAsyncService() {

        executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        executor.setCorePoolSize(2);
        executor.setThreadNamePrefix("ThreadAsync_");
        executor.setKeepAliveSeconds(5);
        executor.setAllowCoreThreadTimeOut(true);
    }

    /**
     * 작업 추가
     * @param key
     * @throws Exception
     */
    synchronized public void addJob(String key) throws Exception {
        if(jobMap.get(key) != null)
            throw new Exception(key + " already executed!");

        JobCallBack cb = new JobCallBack() {
            @Override
            public void onCompleted() {
                jobMap.remove(key);
                log.info(key + " completed!");
            }
        };
        JobRunnable runnable = new JobRunnable(key, cb);

        executor.execute(runnable);
        jobMap.put(key, runnable);
        log.info(key + " job added!");
    }

    /**
     * 작업 종료
     * @param key
     */
    synchronized public void stopJob(String key) {
        JobRunnable runnable = jobMap.get(key);
        if(runnable == null) {
            log.warn("no such job - " + key);
        }

        runnable.cancel();
        jobMap.remove(key);
    }

    /**
     * 작업 CallBack 인터페이스
     */
    private interface JobCallBack {

        public void onCompleted();
    }

    /**
     * 비동기 작업자
     */
    private class JobRunnable implements Runnable {

        private String key;
        private JobCallBack cb;
        private boolean isCancel = false;

        JobRunnable(String key, JobCallBack cb) {
            this.key = key;
            this.cb = cb;
        }

        /**
         * 작업 실행
         */
        @Override
        public void run() {

            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                    log.info(key + " running: " + i);
                    if(isCancel) break;
                }

                if(cb != null)
                    cb.onCompleted();

            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }

        /**
         * 작업 중지
         */
        public void cancel() {
            isCancel = true;
            log.info(key + " cancelled");
        }
    }
}
