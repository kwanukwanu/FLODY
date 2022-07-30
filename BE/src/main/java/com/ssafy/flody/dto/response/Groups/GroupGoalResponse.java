package com.ssafy.flody.dto.response.Groups;

import com.ssafy.flody.domain.groups.goals.GGoals;
import lombok.Getter;

import java.util.Date;

//List-Detail 모두 동일
@Getter
public class GroupGoalResponse {
    private Long ggNo;
    private Long groNo;
    private String name;
    private Date registDate;
    private Date dueDate;

    public GroupGoalResponse(GGoals entity){
        this.ggNo = entity.getGgNo();
        this.groNo = entity.getGroNo();
        this.name = entity.getName();
        this.registDate = entity.getRegistDate();
        this.dueDate = entity.getDueDate();
    }
}
