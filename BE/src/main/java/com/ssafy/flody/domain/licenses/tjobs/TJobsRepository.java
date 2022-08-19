package com.ssafy.flody.domain.licenses.tjobs;

import com.ssafy.flody.domain.licenses.departments.Departments;
import com.ssafy.flody.domain.licenses.fields.Fields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TJobsRepository extends JpaRepository<TJobs, Long> {
    List<TJobs> findAllByField(Fields field);
    List<TJobs> findAllByDepartment(Departments department);
}
