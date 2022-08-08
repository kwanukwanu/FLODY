package com.ssafy.flody.dto.response.licenses;

import com.ssafy.flody.domain.licenses.fields.Fields;
import lombok.Getter;

@Getter
public class FieldListResponseDto {
    private String obligfldnm;
    private Integer oblilgfldcd;

    public FieldListResponseDto(Fields entity){
        this.obligfldnm = entity.getObligfldnm();
        this.oblilgfldcd = entity.getObligfldcd();
    }
}
