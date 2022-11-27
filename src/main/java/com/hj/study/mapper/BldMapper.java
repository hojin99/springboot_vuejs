package com.hj.study.mapper;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface BldMapper {

    List<LinkedHashMap<String, Object>> getBldList();
}
