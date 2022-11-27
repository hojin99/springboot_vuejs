package com.hj.study.api;

import com.hj.study.mapper.BldMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class BldController {

    private final BldMapper bldMapper;

    public BldController(BldMapper bldMapper) {
        this.bldMapper = bldMapper;
    }

    @GetMapping("/bld/list")
    public List<LinkedHashMap<String, Object>> bldList() {

        return bldMapper.getBldList();
    }
}
