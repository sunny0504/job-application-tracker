package com.goutham.JobApplicationTracking.controller;

import com.goutham.JobApplicationTracking.dto.UpdateJobRequestDto;
import com.goutham.JobApplicationTracking.model.JobEntity;
import com.goutham.JobApplicationTracking.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    public JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobEntity> createJob(@RequestBody JobEntity job){
        JobEntity saved = jobService.createJobService(job);
        URI location = URI.create("/api/jobs/" + saved.getJobId());
        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<JobEntity>> getAllJobs(){
        return ResponseEntity.ok(jobService.getAllJobService());
    }

    @GetMapping("/{id}")
    public JobEntity getJobById(@PathVariable Integer id){
        return jobService.getJobByIdService(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobEntity> updateJob(@PathVariable Integer id, @Valid @RequestBody UpdateJobRequestDto dto){
        JobEntity updated = jobService.updateJob(id, dto);
        return ResponseEntity.ok(updated);
    }
}
