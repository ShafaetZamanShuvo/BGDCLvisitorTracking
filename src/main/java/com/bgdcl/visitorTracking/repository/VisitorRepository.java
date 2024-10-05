package com.bgdcl.visitorTracking.repository;

import com.bgdcl.visitorTracking.model.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    Page<Visitor> findAll(Pageable pageable);

}
