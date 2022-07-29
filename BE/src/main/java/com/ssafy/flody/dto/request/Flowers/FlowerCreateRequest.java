package com.ssafy.flody.dto.request.Flowers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FlowerCreateRequest {
    private Long useNo;
    private Long floNo;
    private Integer exp;

    @Builder
    public  FlowerCreateRequest(Long useNo, Long floNo, Integer exp){
        this.useNo = useNo;
        this.floNo = floNo;
        this.exp = exp;
    }
    // DTO to ENTITY
/*    public Flowers toEntity(){
        return Flowers.builder()
                .useNo(useNo)
                .floNo(floNo)
                .exp(exp)
                .build();
    }*/
}
