package com.ssafy.flody.dto.request.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupUpdateRequestDto {
    private String name;

    @Builder
    public GroupUpdateRequestDto(String name){
        this.name = name;
    }
}
