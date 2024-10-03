package com.bgdcl.visitorTracking.service;

import com.bgdcl.visitorTracking.model.Visitor;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitorService {
    Visitor addVisitor(@Valid Visitor visitor);

    List<Visitor> getVisitorsList();

    Visitor markExit(Long id);
}
