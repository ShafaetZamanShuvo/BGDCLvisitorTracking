package com.bgdcl.visitorTracking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visitors")
public class VisitorController {

    @GetMapping("/get-all")
    public ResponseEntity<?> getVisitorsList()
    {
        return ResponseEntity.ok("visitors");
    }
}
