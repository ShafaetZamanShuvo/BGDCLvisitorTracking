package com.bgdcl.visitorTracking.service;

import com.bgdcl.visitorTracking.model.Visitor;
import com.bgdcl.visitorTracking.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getVisitorsList() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor markExit(Long id) {
        return visitorRepository.findById(id).map(visitor -> {
            visitor.setExitTime(LocalDateTime.now());
            return visitorRepository.save(visitor);
        }).orElseThrow(() -> new RuntimeException("Visitor not found with id " + id));
    }
}
