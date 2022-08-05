package com.ssafy.flody.dto.response.licenses;

import com.ssafy.flody.domain.licenses.mfields.MFields;
import lombok.Getter;

@Getter
public class MFieldsListResponseDto {
    private String mobligfldnm;
    private Integer moblilgfldcd;

    public MFieldsListResponseDto(MFields entity){
        this.mobligfldnm = entity.getMobligfldnm();
        this.moblilgfldcd = entity.getMobligfldcd();
    }
}
