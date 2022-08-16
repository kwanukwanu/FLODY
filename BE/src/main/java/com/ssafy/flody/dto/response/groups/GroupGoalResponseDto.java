package com.ssafy.flody.dto.response.groups;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.groups.goals.GGoals;
import lombok.Getter;

import java.util.Calendar;
import java.util.Date;

//List-Detail 모두 동일
@Getter
public class GroupGoalResponseDto {
    private Long ggNo;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public GroupGoalResponseDto(GGoals entity){
        this.ggNo = entity.getGgNo();
        this.name = entity.getName();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getRegistDate());
        cal.add(Calendar.DATE, 1);
        this.registDate = cal.getTime();
        cal.setTime(entity.getDueDate());
        cal.add(Calendar.DATE, 1);
        this.dueDate = cal.getTime();
    }
}
