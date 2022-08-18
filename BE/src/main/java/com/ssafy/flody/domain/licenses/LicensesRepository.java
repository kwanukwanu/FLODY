package com.ssafy.flody.domain.licenses;

import com.ssafy.flody.domain.licenses.fields.Fields;
import com.ssafy.flody.domain.licenses.mfields.MFields;
import com.ssafy.flody.domain.licenses.serieses.Serieses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicensesRepository extends JpaRepository<Licenses, Long> {
    List<Licenses> findAllByMfield(MFields mfield);
    List<Licenses> findAllBySeries(Serieses series);
    List<Licenses> findAllByFieldAndMfieldAndJmfldnmContainingIgnoreCase(Fields field, MFields mField, String jmfldnm);
    List<Licenses> findAllByFieldAndJmfldnmContainingIgnoreCase(Fields field, String jmfldnm);
    List<Licenses> findAllByJmfldnmContainingIgnoreCase(String jmfldnm);
}
