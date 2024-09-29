package com.jobhunt.api.controller;

import com.jobhunt.api.entity.User;
import com.jobhunt.api.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userLogin")
@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
public class UserLogin {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> authenticateCustomer(@RequestBody User user) {
        try {
            Optional<User> userEmailId = Optional.ofNullable(userService.findByUserEmailId(user.getEmailId()));
            if (userEmailId.isPresent()) {
                User foundUser = userEmailId.get();
                if (foundUser.getPassword().equals(user.getPassword())) {
                    foundUser.setPassword("");
                    log.info("Authentication successful for user: {}", user.getEmailId());
                    return new ResponseEntity<>(foundUser, HttpStatus.OK);
                }
                log.info("Password mismatch for user: {}", user.getEmailId());
            } else {
                log.info("User not found: {}", user.getEmailId());
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            log.error("Authentication error for user: {}", user.getEmailId(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
