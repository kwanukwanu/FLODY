package com.ssafy.flody.domain.licenses.departments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    Optional<Departments> findByUdeptnm(String udeptnm);
}
