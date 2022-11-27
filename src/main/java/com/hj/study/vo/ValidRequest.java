package com.hj.study.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ValidRequest {

    @NotBlank(message = "길이가 5이어야 합니다.")
    @Size(min=5,max=5)
    private String id;

    @NotBlank
    @Size(max=100)
    private String name;

    @Positive
    @Max(value=120)
    private int age;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String email;

    private boolean isAdult;

    private String hobby;
}
