package com.user.data.management.controller;

import com.user.data.management.model.UserManagementDetails;
import com.user.data.management.service.UserManagementDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserManagementDetailsControllerTest {

    @Autowired
    UserManagementDetailsController userManagementDetailsController;

    @MockitoBean
    UserManagementDetailsService userManagementDetailsService;

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String EMAIL = "john.doe@example.com";
    private static final String USERNAME = "johndoe123";
    private static final String PASSWORD = "Secure@123";
    private static final Set<String> ROLES = new HashSet<>(Set.of("USER"));

    @Test
    public void testFindByUserNameSuccess(){
        when(userManagementDetailsService.findByUsername(anyString())).thenReturn(fetchUserManagementDetails());
        ResponseEntity<Optional<UserManagementDetails>> responseEntity = userManagementDetailsController.findByUsername(anyString());
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    private Optional<UserManagementDetails> fetchUserManagementDetails() {
        UserManagementDetails userManagementDetails = new UserManagementDetails();
        userManagementDetails.setFirstName(FIRST_NAME);
        userManagementDetails.setLastName(LAST_NAME);
        userManagementDetails.setEmail(EMAIL);
        userManagementDetails.setUsername(USERNAME);
        userManagementDetails.setPassword(PASSWORD);
        userManagementDetails.setRole(ROLES);
        return Optional.of(userManagementDetails);
    }
}
