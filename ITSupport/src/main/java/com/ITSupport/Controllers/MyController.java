package com.ITSupport.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/my-endpoint")
    public ResponseEntity<String> myEndpoint() {
        return ResponseEntity.ok("Hello, World!");
    }
}
