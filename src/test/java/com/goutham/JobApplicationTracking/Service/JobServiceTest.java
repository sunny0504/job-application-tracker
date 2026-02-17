package com.goutham.JobApplicationTracking.Service;

import com.goutham.JobApplicationTracking.ApplicationStatus;
import com.goutham.JobApplicationTracking.model.JobEntity;
import com.goutham.JobApplicationTracking.repository.JobRepository;
import com.goutham.JobApplicationTracking.service.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

public class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobService jobService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createJob_ShouldSetAppliedStausAndDate(){
        JobEntity inputJob = new JobEntity();

        inputJob.setCompanyName("Google");
        inputJob.setJobRoleName("Backend Developer");
        inputJob.setSalary(1500000);
        inputJob.setLocation("Hyderabad");

        when(jobRepository.save(any(JobEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        JobEntity savedJob = jobService.createJobService(inputJob);

        // Assert
        assertEquals(LocalDate.now(),savedJob.getAppliedDate());
        assertEquals(ApplicationStatus.APPLIED,savedJob.isApplicationStatus());

        verify(jobRepository, times(1)).save(any(JobEntity.class));
    }
}
