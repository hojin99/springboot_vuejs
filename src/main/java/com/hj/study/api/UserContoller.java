package com.hj.study.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hj.study.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@RestController
public class UserContoller {

    private final UserMapper userMapper;

    private final ObjectMapper om;

    public UserContoller(UserMapper userMapper, ObjectMapper om) {
        this.userMapper = userMapper;
        this.om = om;
    }

    @GetMapping("/user/list")
    public List<LinkedHashMap<String, Object>> bldList() {

        return userMapper.getUserList();
    }

    @PostMapping("/user/insert")
    public ResponseEntity<String> insertUser(@RequestBody HashMap<String, Object> user) throws Exception {

        userMapper.insertUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(om.writeValueAsString(user));
    }

    @PostMapping("/user/{userSeq}/update")
    public ResponseEntity<String> updateUser(@PathVariable int userSeq, @RequestBody HashMap<String, Object> user) throws Exception {

        log.info("userSeq body : " + user.get("user_seq"));
        log.info("userSeq path : " + userSeq);

        if(!user.get("user_seq").equals(userSeq))
            throw new ApiException("Invalid userSeq");

        userMapper.updateUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(om.writeValueAsString(user));
    }

    @PostMapping("/user/{userSeq}/delete")
    public ResponseEntity<String> updateUser(@PathVariable int userSeq) throws Exception {

        userMapper.deleteUser(userSeq);

        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(userSeq));
    }
}
