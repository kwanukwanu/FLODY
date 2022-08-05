package com.ssafy.flody.dto.response.licenses;

import com.ssafy.flody.domain.licenses.Licenses;
import lombok.Getter;

@Getter
public class LicensesListResponseDto {
    private String jmfldnm;
    private Integer jmcd;
    private String qualgbcd;

    public LicensesListResponseDto(Licenses entity){
        this.jmfldnm = entity.getJmfldnm();
        this.jmcd = entity.getJmcd();
        this.qualgbcd = entity.getQualgbcd();
    }
}
