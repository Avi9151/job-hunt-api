package com.jobhunt.api.controller;

import com.jobhunt.api.entity.HR;
import com.jobhunt.api.entity.User;
import com.jobhunt.api.service.HRService;
import com.jobhunt.api.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hrLogin")
@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
public class HRLogin {

    @Autowired
    private HRService hrService;
    @PostMapping
    public HR authenticateCustomer(@RequestBody HR hr){
        Optional<HR> hrEmailId = Optional.ofNullable(hrService.findByHrEmailId(hr.getEmailId()));
        if (hrEmailId.isPresent()){
            HR emailId = hrEmailId.get();
            if (emailId.getPassword().equals(hr.getPassword())){

                emailId.setPassword("");
                log.info("Authentication successful");
                return emailId;
            }
            log.info("Password not matching");
        }
        log.info("EmailId not matching");
        throw new RuntimeException("Invalid username or password");
    }
}
