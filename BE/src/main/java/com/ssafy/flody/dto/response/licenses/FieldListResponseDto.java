package com.ssafy.flody.dto.response.licenses;

import com.ssafy.flody.domain.licenses.fields.Fields;
import lombok.Getter;

@Getter
public class FieldListResponseDto {
    private String obligfldnm;
    private String oblilgfldcd;

    public FieldListResponseDto(Fields entity){
        this.obligfldnm = entity.getObligfldnm();
        this.oblilgfldcd = entity.getObligfldcd();
    }
}
