package com.ITSupport.Controllers;

import com.ITSupport.Models.Panne;
import com.ITSupport.Services.PanneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    PanneServiceImpl panneService;
    @RequestMapping("/my-endpoint")
    public ResponseEntity<String> myEndpoint() {
        return ResponseEntity.ok("Hello, World!");
    }


    @PostMapping("/add")
    public Panne createPanne(@Validated @RequestBody Panne panneDTO) {
        // Panne createdPanne = panneService.createPanne(panneDTO);
        //return ResponseEntity.status(201).body(createdPanne);
        return panneService.createPanne(panneDTO);
    }
}
