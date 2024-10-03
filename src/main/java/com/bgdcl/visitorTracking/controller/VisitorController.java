package com.bgdcl.visitorTracking.controller;

import com.bgdcl.visitorTracking.model.Visitor;
import com.bgdcl.visitorTracking.service.VisitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/visitors")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getVisitorsList()
    {
        List<Visitor> visitors = visitorService.getVisitorsList();
        return ResponseEntity.ok(visitors);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addVisitor(@RequestBody @Valid Visitor visitor)
    {
        Visitor newVisitor = visitorService.addVisitor(visitor);
        return ResponseEntity.ok(newVisitor);
    }

    @PostMapping("/mark-exit/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> markExit(@PathVariable Long id)
    {
        Visitor visitor = visitorService.markExit(id);
        return ResponseEntity.ok(visitor);
    }

}
