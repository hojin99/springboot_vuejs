package com.hj.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@EnableScheduling
@EnableRetry
@SpringBootApplication
public class StudyApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("### 4. ApplicationRunner run!");
	}
}
