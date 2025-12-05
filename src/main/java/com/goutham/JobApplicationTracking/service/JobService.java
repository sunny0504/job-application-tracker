package com.goutham.JobApplicationTracking.service;

import com.goutham.JobApplicationTracking.model.JobEntity;
import com.goutham.JobApplicationTracking.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    public JobRepository jobRepository;

    public JobEntity createJobService(JobEntity job){

        job.setAppliedDate(LocalDate.now());
        job.setApplicationStatus(true);

        return jobRepository.save(job);
    }

    public List<JobEntity> getAllJobService(){
        return jobRepository.findAll();
    }

    public Optional<JobEntity> getJobByIdService(Integer id){
        return  jobRepository.findById(id);
    }
}
