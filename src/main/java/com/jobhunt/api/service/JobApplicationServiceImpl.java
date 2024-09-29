package com.jobhunt.api.service;

import com.jobhunt.api.entity.JobApplication;
import com.jobhunt.api.repository.JobApplicationRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class JobApplicationServiceImpl implements JobApplicationService {

    private static final Logger log = LoggerFactory.getLogger(JobApplicationServiceImpl.class);
    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Override
    public List<JobApplication> getAllJobApplications() {
        log.info("List find");
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        Optional<JobApplication> optionalJobApplication = jobApplicationRepository.findById(id);
        return optionalJobApplication.orElse(null);
    }

    @Override
    public JobApplication createJobApplication(JobApplication jobApplication) {
        JobApplication newApplication = jobApplicationRepository.save(jobApplication);
        log.info("New Application Apply");
        return newApplication;
    }

    @Override
    public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
        if (jobApplicationRepository.existsById(id)) {
            jobApplication.setId(id);
            return jobApplicationRepository.save(jobApplication);
        } else {
            return null;
        }
    }

    @Override
    public void deleteJobApplication(Long id) {
        jobApplicationRepository.deleteById(id);
    }
}

