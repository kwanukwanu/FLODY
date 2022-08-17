package com.ssafy.flody.dto.request.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
public class GroupUpdateRequestDto {
    private Long groNo;
    @Nullable
    private String name;
    @Nullable
    private String introduction;

    @Builder
    public GroupUpdateRequestDto(Long groNo, String name, String introduction){
        this.groNo = groNo;
        this.name = name;
        this.introduction = introduction;
    }
}
