package com.jobhunt.api.service;


import com.jobhunt.api.entity.Job;
import com.jobhunt.api.repository.JobRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        log.info("Job list fetching");
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        log.info("Job find by id"+id);
        return jobRepository.findById(id).orElse(null);
    }

    public Job createJob(Job job) {
        log.info("New job saved");
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job updatedJob) {
        Job existingJob = jobRepository.findById(id).orElse(null);
        if (existingJob != null) {
            existingJob.setTitle(updatedJob.getTitle());
            existingJob.setCompany(updatedJob.getCompany());
            existingJob.setLocation(updatedJob.getLocation());
            existingJob.setDescription(updatedJob.getDescription());
            existingJob.setSalary(updatedJob.getSalary());
            existingJob.setTechnologies(updatedJob.getTechnologies());
            log.info("Job updated"+id);
            return jobRepository.save(existingJob);
        }
        return null;
    }

    public void deleteJob(Long id) {
        log.info("Job deleted"+id);
        jobRepository.deleteById(id);
    }

}

