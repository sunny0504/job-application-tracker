package com.goutham.JobApplicationTracking.repository;

import com.goutham.JobApplicationTracking.model.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,Integer> {
}
