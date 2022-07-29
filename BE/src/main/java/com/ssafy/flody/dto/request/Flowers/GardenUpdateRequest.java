package com.ssafy.flody.dto.request.Flowers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GardenUpdateRequest {
    private Long useNo;
    private Long floNo;
    private Integer exp;

    @Builder
    public GardenUpdateRequest(
            Long useNo, Long floNo, Integer exp
    ){
        this.useNo = useNo;
        this.floNo = floNo;
        this.exp = exp;
    }
}
