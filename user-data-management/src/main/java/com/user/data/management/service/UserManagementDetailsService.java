package com.user.data.management.service;

import com.user.data.management.model.UserManagementDetails;

import java.util.List;
import java.util.Optional;

public interface UserManagementDetailsService {

    Optional<UserManagementDetails> findByUsername(String username);

    Optional<UserManagementDetails> save(UserManagementDetails userManagementDetails);

    Optional<List<UserManagementDetails>> findAll();

    String delete(Integer id);

    String update(UserManagementDetails userDetails);
}
