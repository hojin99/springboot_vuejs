package com.hj.study.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class ValidResponse {

    private String message;

    private HashMap errorMessage;
}
