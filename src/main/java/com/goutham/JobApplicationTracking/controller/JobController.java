package com.goutham.JobApplicationTracking.controller;

import com.goutham.JobApplicationTracking.dto.ApiResponseDto;
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

    private final JobService jobService;

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
    public ResponseEntity<ApiResponseDto<List<JobEntity>>> getAllJobs(){
        System.out.println("Get all Jobs Hit");
        return ResponseEntity.ok(ApiResponseDto.success(200,"Jobs fetched successfully",jobService.getAllJobService()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<JobEntity>> getJobById(@PathVariable Integer id){
        return ResponseEntity.ok(ApiResponseDto.success(200,"Job fetched successfully",jobService.getJobByIdService(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto<JobEntity>> updateJob(@PathVariable Integer id, @Valid @RequestBody UpdateJobRequestDto dto){
        JobEntity updated = jobService.updateJob(id, dto);
        return ResponseEntity.ok(ApiResponseDto.success(200,"Job Updated successfully",updated));
    }
}
