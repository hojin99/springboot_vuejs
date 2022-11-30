package com.hj.study.api;

import com.hj.study.service.AsyncCaller;
import com.hj.study.service.ThreadAsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    private final ThreadAsyncService service;
    private final AsyncCaller aservice;

    public JobController(ThreadAsyncService service, AsyncCaller aservice) {

        this.service = service;
        this.aservice = aservice;
    }

    @GetMapping("job/add")
    public String addJob(@RequestParam String key) {

        try {
            service.addJob(key);
        } catch(Exception e) {
            return "FAIL - " + e.getMessage();
        }
        return "OK";
    }

    @GetMapping("job/{job}/cancel")
    public String cancelJob(@PathVariable String job) {

        try {
            service.stopJob(job);
        } catch(Exception e) {
            return "FAIL - " + e.getMessage();
        }

        return "OK";
    }

    @GetMapping("ajob/add")
    public String addAsyncJob(@RequestParam String key) {

        try {
            aservice.addJob(key);
        } catch(Exception e) {
            return "FAIL - " + e.getMessage();
        }
        return "OK";
    }

    @GetMapping("ajob/{job}/cancel")
    public String cancelAsyncJob(@PathVariable String job) {

        try {
            aservice.stopJob(job);
        }catch(Exception e) {
            return "FAIL - " + e.getMessage();
        }

        return "OK";
    }

}
