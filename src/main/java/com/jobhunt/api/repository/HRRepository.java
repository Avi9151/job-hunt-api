package com.jobhunt.api.repository;

import com.jobhunt.api.entity.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR, Long> {
    public HR findByEmailId(String emailId);
}
