package com.ssafy.flody.dto.request.Groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupUpdateRequest {
    private String name;

    @Builder
    public GroupUpdateRequest(String name){
        this.name = name;
    }
}
