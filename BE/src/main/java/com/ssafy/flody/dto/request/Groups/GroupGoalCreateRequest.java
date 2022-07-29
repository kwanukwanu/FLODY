package com.ssafy.flody.dto.request.Groups;

import com.ssafy.flody.domain.groups.Groups;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupGoalCreateRequest {
    private Long groNo;
    private String name;

    @Builder
    public GroupGoalCreateRequest (Long groNo, String name){
        this.groNo = groNo;
        this.name = name;
    }

    //DTO to Entity
    public Groups toEntity(){
        return Groups.builder()
                .groNo(groNo)
                .name(name)
                .build();
    }
}
