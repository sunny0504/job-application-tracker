package com.goutham.JobApplicationTracking.dto;

import com.goutham.JobApplicationTracking.ApplicationStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateJobRequestDto {

    @NotBlank(message = "jobRoleName must not be blank")
    private String jobRoleName;

    @NotBlank(message = "companyName must not be blank")
    private String companyName;

    @NotBlank(message = "location must not be blank")
    private String location;

    @NotNull(message = "salary must not be null")
    @Min(value = 1000, message = "salary must be positive")
    private Integer salary;

    @NotNull(message = "applicationStatus must not be null")
    private ApplicationStatus applicationStatus;

    public String getJobRoleName() { return jobRoleName; }
    public void setJobRoleName(String jobRoleName) { this.jobRoleName = jobRoleName; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }

    public ApplicationStatus getApplicationStatus() { return applicationStatus; }
    public void setApplicationStatus(ApplicationStatus applicationStatus) { this.applicationStatus = applicationStatus; }
}

