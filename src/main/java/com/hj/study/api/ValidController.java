package com.hj.study.api;

import com.hj.study.vo.ValidRequest;
import com.hj.study.vo.ValidResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedHashMap;

@RestController
public class ValidController {

    @PostMapping("/valid")
    public ResponseEntity<ValidResponse> validate1(@Valid @RequestBody ValidRequest req, Errors errors) {
        ValidResponse result = new ValidResponse();
        LinkedHashMap<String, String> error = new LinkedHashMap<>();

        if(errors.hasFieldErrors()) {
            errors.getFieldErrors().forEach(e-> {
                error.put(e.getField(), e.getDefaultMessage());
            });
            result.setMessage("Error");
            result.setErrorMessage(error);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        result.setMessage("OK");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
