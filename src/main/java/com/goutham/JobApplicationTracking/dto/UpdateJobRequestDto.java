package com.goutham.JobApplicationTracking.dto;

import com.goutham.JobApplicationTracking.ApplicationStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public @NotBlank(message = "jobRoleName must not be blank") String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(@NotBlank(message = "jobRoleName must not be blank") String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public @NotBlank(message = "companyName must not be blank") String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@NotBlank(message = "companyName must not be blank") String companyName) {
        this.companyName = companyName;
    }

    public @NotBlank(message = "location must not be blank") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "location must not be blank") String location) {
        this.location = location;
    }

    public @NotNull(message = "salary must not be null") @Min(value = 1000, message = "salary must be positive") Integer getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "salary must not be null") @Min(value = 1000, message = "salary must be positive") Integer salary) {
        this.salary = salary;
    }

    public @NotNull(message = "applicationStatus must not be null") ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(@NotNull(message = "applicationStatus must not be null") ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}

