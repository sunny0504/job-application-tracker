package com.goutham.JobApplicationTracking.service;

import com.goutham.JobApplicationTracking.ApplicationStatus;
import com.goutham.JobApplicationTracking.dto.UpdateJobRequestDto;
import com.goutham.JobApplicationTracking.exception.ResourceNotFoundException;
import com.goutham.JobApplicationTracking.model.JobEntity;
import com.goutham.JobApplicationTracking.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public JobEntity createJobService(JobEntity job){

        job.setAppliedDate(LocalDate.now());
        job.setApplicationStatus(ApplicationStatus.APPLIED);

        return jobRepository.save(job);
    }

    public List<JobEntity> getAllJobService(){
        return jobRepository.findAll();
    }

    public JobEntity getJobByIdService(Integer id){
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id: "+id));
    }

    public JobEntity updateJob(Integer id, UpdateJobRequestDto dto){
            JobEntity job = jobRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));

            job.setJobRoleName(dto.getJobRoleName());
            job.setCompanyName(dto.getCompanyName());
            job.setLocation(dto.getLocation());
            job.setSalary(dto.getSalary());
            job.setApplicationStatus(dto.getApplicationStatus());

            return jobRepository.save(job);
    }
}
