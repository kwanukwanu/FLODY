package com.ssafy.flody.controller;

import com.ssafy.flody.domain.users.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
    private static final String ERROR = "ERROR";

    @GetMapping("/test")
    public ResponseEntity<String> testController(@RequestParam int option) {
        HttpStatus status;
        String result;

        try {
            if (option == 0) {
                result = SUCCESS;
                status = HttpStatus.ACCEPTED;
            } else {
                result = FAIL;
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            result = ERROR;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }
}
