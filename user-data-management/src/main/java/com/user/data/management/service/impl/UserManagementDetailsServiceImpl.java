package com.user.data.management.service.impl;

import com.user.data.management.model.UserManagementDetails;
import com.user.data.management.repository.UserDetailsRepository;
import com.user.data.management.service.UserManagementDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementDetailsServiceImpl implements UserManagementDetailsService {

    @Autowired
    UserDetailsRepository  userDetailsRepository;

    @Override
    public Optional<UserManagementDetails> findByUsername(String username) {
        return userDetailsRepository.findByUsername(username);
    }

    @Override
    public Optional<UserManagementDetails> save(UserManagementDetails userManagementDetails) {
        return Optional.of(userDetailsRepository.save(userManagementDetails));
    }

    @Override
    public Optional<List<UserManagementDetails>> findAll() {
        return Optional.of(userDetailsRepository.findAll());
    }

    @Override
    public String delete(Integer id) {
        userDetailsRepository.deleteById(id);
        return "User details has been deleted successfully";
    }

    @Override
    public String update(UserManagementDetails userDetails) {
        userDetailsRepository.save(userDetails);
        return "User details has been updated successfully";
    }
}