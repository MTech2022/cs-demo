package com.mit.mtech.student.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/")
public class SQLInjection {

    @GetMapping
    public ResponseEntity getAllPasswords(@RequestParam(name = "username") String username) {

        return null;
    }
}
