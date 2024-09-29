package com.jobhunt.api.service;

import com.jobhunt.api.entity.JobApplication;
import java.util.List;

public interface JobApplicationService {

    List<JobApplication> getAllJobApplications();

    JobApplication getJobApplicationById(Long id);

    JobApplication createJobApplication(JobApplication jobApplication);

    JobApplication updateJobApplication(Long id, JobApplication jobApplication);

    void deleteJobApplication(Long id);
}
