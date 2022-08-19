package com.ssafy.flody.domain.licenses.departments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    List<Departments> findByUdeptnmContainingIgnoreCase(String udeptnm);
    Optional<Departments> findByUdeptnm(String udeptnm);
}
