package com.user.data.management.controller;

import com.user.data.management.model.UserManagementDetails;
import com.user.data.management.service.UserManagementDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserManagementDetailsController {

    @Autowired
    UserManagementDetailsService userManagementDetailsService;

    @GetMapping("/oneuser")
    public ResponseEntity<Optional<UserManagementDetails>> findByUsername(@RequestParam String username) {
        return new  ResponseEntity<>(userManagementDetailsService.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Optional<UserManagementDetails>> save(@RequestBody UserManagementDetails userManagementDetails) {
        return new  ResponseEntity<>(userManagementDetailsService.save(userManagementDetails), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
       String message =  userManagementDetailsService.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update( @RequestBody UserManagementDetails userManagementDetails) {
        String message =  userManagementDetailsService.update(userManagementDetails);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Optional<List<UserManagementDetails>>> findAll() {
        return new  ResponseEntity<>(userManagementDetailsService.findAll(), HttpStatus.OK);
    }
}
