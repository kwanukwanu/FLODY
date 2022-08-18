package com.ssafy.flody.domain.licenses.fields;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FieldsRepository extends JpaRepository<Fields, Long> {
    Optional<Fields> findByObligfldnm(String obligfldnm);
}
