package com.jobhunt.api.repository;


import com.jobhunt.api.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

