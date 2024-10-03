package com.bgdcl.visitorTracking.repository;

import com.bgdcl.visitorTracking.model.ERole;
import com.bgdcl.visitorTracking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
