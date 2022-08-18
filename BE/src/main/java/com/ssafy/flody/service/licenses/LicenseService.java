package com.ssafy.flody.service.licenses;

import com.ssafy.flody.dto.response.licenses.LicensesResponseDto;

import java.util.List;

public interface LicenseService {
    public String getLicense() throws Exception;
    public List<LicensesResponseDto> findLicenses(String fldnm, String mfldnm, String category, String keyword);
    public List<String> findAllFields();
    public List<String> findAllMFields(String fldnm);
}
