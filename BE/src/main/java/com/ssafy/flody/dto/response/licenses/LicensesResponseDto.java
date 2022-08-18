package com.ssafy.flody.dto.response.licenses;

import com.ssafy.flody.domain.licenses.Licenses;
import lombok.Getter;

@Getter
public class LicensesResponseDto {
    private Long lisNo;
    private String fldnm;
    private String mfldnm;
    private String sernm;
    private String jmnm;
    private String qualnm;

    public LicensesResponseDto(Licenses entity){
        this.lisNo = entity.getLisNo();
        this.fldnm = entity.getField().getObligfldnm();
        this.mfldnm = entity.getMfield().getMobligfldnm();
        this.sernm = entity.getSeries().getSeriesnm();
        this.jmnm = entity.getJmfldnm();
        this.qualnm = entity.getQualgbnm();
    }
}
