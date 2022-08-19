package com.ssafy.flody.domain.licenses.sjobs;

import com.ssafy.flody.domain.licenses.departments.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SJobsRepository extends JpaRepository<SJobs, Long> {
    List<SJobs> findAllByDepartment(Departments department);
}
