# springboot + vue.js
spring boot, vue.js 기본 사용법에 대한 테스트 용도  

## spring boot

### 환경
* java 11 사용 (기설치 되어야 함)
* maven 사용 (기설치 되어야 함)
* intelliJ Community Edition 사용
* spring boot 2.6.3 사용

### 실행
1. maven 프로젝트 추가, reload 실행 
   - 프로젝트를 받으면 자동으로 maven 프로젝트로 추가됨 (만약, 추가가 안 되면 수동 추가)
   - reload도 자동으로 되지만, 만약 안 될 경우 수동 추가 (pom.xml이나 컨텍스트 메뉴, 툴바 등에서 reload)
2. src/main/java에서 com.hj.study.StudyApplication 실행 (컨텍스트 메뉴, 툴바 등에서)

### 참조 
https://spring.io/quickstart  
https://spring.io/guides  

### 어플리케이션 이벤트
* @EventListner, @PostContruct, @PreDestory 이용하는 예제 - ApplicationContextListner

### 스케쥴링
* @EnableScheduling, @Scheduled 이용하는 예제 - LoggingTask, SchedulerConfig
* ThreadPoolTaskScheduler 직접 사용하는 예제 - SelfLoggingTask

### 재시도
* @EnableRetry, @Retryable 이용하는 예제 - RetryService, RetryTask

### Validation
* @Valid, javax.validation.constraints.* 이용하는 예제 - ValidController, ValidRequest, ValidResponse

### Mybatis
* mybatis, postgresql 이용하는 예제 - docker/springboot_db/* , MyBatisConfig, UserMapper.xml, UserMapper, UserController

### Exception 처리
* @RestControllerAdvice 이용하는 예제 - ApiException, ApiExceptionHandler, UserController

## vue.js
src/main/webapp/README 참조  


