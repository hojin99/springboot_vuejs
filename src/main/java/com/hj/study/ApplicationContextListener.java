package com.hj.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class ApplicationContextListener {

    /**
     * Bean 생성자
     *
     */
    public ApplicationContextListener() {
        log.info("### 1. ApplicationContextListener construct called!");
    }

    /**
     * Bean 생성자 호출 후 호출됨
     *
     */
    @PostConstruct
    public void init() {
        log.info("### 2. PostConstruct init called!");
    }

    /**
     * ApplicationContext가 초기화 되거나 Refesh 될 때 호출됨 (여러번 호출 될 수 있어서 체크 필요)
     * ContextStartedEvent는 ConfigurableApplicationContext start()시만 호출 되기 때문에 초기화에 부적합
     * 
     * @param event
     */
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {

        // 처음 호출 되는 게 아닐 경우 return
        if(event.getApplicationContext().getParent() != null)
            return;
        
        log.info("### 3. ContextRefreshedEvent called!");
    }

    /**
     * Application 구동이 완료 되고 최종 적으로 호출됨
     * 
     * @param event
     */
    @EventListener
    public void handleApplicationReady(ApplicationReadyEvent event) {
        log.info("### 5. ApplicationReadyEvent called!");
    }

    /**
     * ApplicationContext가 종료 될 때 호출됨 (Application 종료 처리)
     *
     * @param event
     */
    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
        log.info("### ContextClosedEvent called!");
    }

    @PreDestroy
    public void destroy() {
        log.info("### PreDestroy destroy called!");
    }

}
