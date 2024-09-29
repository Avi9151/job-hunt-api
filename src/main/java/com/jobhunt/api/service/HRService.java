package com.jobhunt.api.service;

import com.jobhunt.api.entity.HR;

import java.util.List;
import java.util.Optional;

public interface HRService {

    public List<HR> getAllHr();
    public HR newHr(HR hr);
    public HR update(HR hr);
    public HR deleteById(Long id);
    public HR findByHrEmailId(String emailId);
    Optional<HR> getHrById(Long hrId);
}
