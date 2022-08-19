package com.ssafy.flody.domain.licenses.mfields;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MFieldsRepository extends JpaRepository<MFields, Long> {
    Optional<MFields> findByMobligfldnm(String mobligfldnm);
}
