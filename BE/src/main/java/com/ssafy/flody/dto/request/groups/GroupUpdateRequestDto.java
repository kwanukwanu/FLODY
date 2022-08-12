package com.ssafy.flody.dto.request.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupUpdateRequestDto {
    private Long groNo;
    private String name;

    @Builder
    public GroupUpdateRequestDto(Long groNo, String name){
        this.groNo = groNo;
        this.name = name;
    }
}
