package com.user.data.management.repository;

import com.user.data.management.model.UserManagementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserManagementDetails, Integer> {
    Optional<UserManagementDetails> findByUsername(String username);
}
