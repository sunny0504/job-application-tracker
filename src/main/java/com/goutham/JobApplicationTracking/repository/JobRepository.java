package com.goutham.JobApplicationTracking.repository;

import com.goutham.JobApplicationTracking.model.JobEntity;
import com.goutham.JobApplicationTracking.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,Integer> {
}
