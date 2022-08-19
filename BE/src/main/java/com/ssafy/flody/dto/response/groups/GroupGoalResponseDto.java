package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.goals.GGoals;
import lombok.Getter;

import java.util.Date;

//List-Detail 모두 동일
@Getter
public class GroupGoalResponseDto {
    private String name;
    private Date registDate;
    private Date dueDate;

    public GroupGoalResponseDto(GGoals entity){
        this.name = entity.getName();
        this.registDate = entity.getRegistDate();
        this.dueDate = entity.getDueDate();
    }
}
