package com.goutham.JobApplicationTracking.controller;

import com.goutham.JobApplicationTracking.model.JobEntity;
import com.goutham.JobApplicationTracking.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

    public JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobEntity> createJob(@RequestBody JobEntity job){
        return ResponseEntity.ok(jobService.createJobService(job));
    }

    @GetMapping
    public ResponseEntity<List<JobEntity>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobService());
    }
}
