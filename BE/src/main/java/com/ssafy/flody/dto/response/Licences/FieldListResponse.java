package com.ssafy.flody.dto.response.Licences;

import com.ssafy.flody.domain.licences.fields.Fields;
import lombok.Getter;

@Getter
public class FieldListResponse {
    private Long fieNo;
    private String obligfldnm;
    private Integer oblilgfldcd;

    public FieldListResponse(Fields entity){
        this.fieNo = entity.getFieNo();
        this.obligfldnm = entity.getObligfldnm();
        this.oblilgfldcd = entity.getObligfldcd();
    }
}
