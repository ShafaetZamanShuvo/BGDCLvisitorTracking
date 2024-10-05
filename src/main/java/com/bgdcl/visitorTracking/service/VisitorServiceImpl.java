package com.bgdcl.visitorTracking.service;

import com.bgdcl.visitorTracking.model.Visitor;
import com.bgdcl.visitorTracking.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public Visitor addVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Page<Visitor> getVisitorsList(int page, int size) {
        return visitorRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "entryTime")));
    }

    @Override
    public Visitor markExit(Long id) {
        return visitorRepository.findById(id).map(visitor -> {
            visitor.setExitTime(LocalDateTime.now());
            return visitorRepository.save(visitor);
        }).orElseThrow(() -> new RuntimeException("Visitor not found with id " + id));
    }
}
