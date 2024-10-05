package com.bgdcl.visitorTracking.service;

import com.bgdcl.visitorTracking.model.Visitor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitorService {
    Visitor addVisitor(@Valid Visitor visitor);

    Page<Visitor> getVisitorsList(int page, int size);

    Visitor markExit(Long id);
}
