package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.Groups;
import lombok.Getter;

@Getter
public class GroupDetailResponseDto {
    private String name;

    public GroupDetailResponseDto(Groups entity){
        this.name = entity.getName();
    }
}
