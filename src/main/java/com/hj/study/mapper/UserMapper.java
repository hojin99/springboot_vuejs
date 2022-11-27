package com.hj.study.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Repository
public interface UserMapper {

    void insertUser(HashMap<String,Object> param);

    List<LinkedHashMap<String, Object>> getUserList();

    void updateUser(HashMap<String,Object> param);

    void deleteUser(int userSeq);

}
