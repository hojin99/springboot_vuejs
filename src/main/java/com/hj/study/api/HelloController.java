package com.hj.study.api;

import com.hj.study.mapper.BldMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="World", required = true) String name) {
        return String.format("Hello %s!", name);
    }



}
