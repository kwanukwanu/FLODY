package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.goals.UGoals;
import lombok.Getter;

import java.util.Date;

@Getter
public class UserGoalResponseDto {
    private String title;
    private Date registDate;
    private Date dueDate;

    public UserGoalResponseDto(UGoals entity){
        this.title = entity.getName();
        this.registDate = entity.getRegistDate();
        this.dueDate = entity.getDueDate();
    }
}
