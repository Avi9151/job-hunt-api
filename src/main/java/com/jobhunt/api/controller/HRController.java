package com.jobhunt.api.controller;


import com.jobhunt.api.entity.HR;
import com.jobhunt.api.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hr")
@CrossOrigin(origins = "http://localhost:3000")
public class HRController {

    @Autowired
    private HRService hrService;

    @GetMapping
    public List<HR> getAllHr(){
        return hrService.getAllHr();
    }

    @PostMapping
    public HR newHr(@RequestBody HR hr){
        return hrService.newHr(hr);
    }

    @PutMapping
    public HR updateHr(@RequestBody HR hr){
        return hrService.update(hr);
    }

    @DeleteMapping("/{id}")
    public HR delete(@PathVariable Long id){
        hrService.deleteById(id);
        return null;
    }

    @GetMapping("/{hrId}")
    public Optional<HR> findById(@PathVariable Long hrId){
        return hrService.getHrById(hrId);
    }
}
