package com.samarthanam.registration.service.repository;

import java.util.Optional;

import com.samarthanam.registration.service.models.ERole;
import com.samarthanam.registration.service.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
