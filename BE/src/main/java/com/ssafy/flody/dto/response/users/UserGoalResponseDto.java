package com.ssafy.flody.dto.response.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.users.goals.UGoals;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
public class UserGoalResponseDto {
    private Long ugNo;
    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public UserGoalResponseDto(UGoals entity){
        this.ugNo = entity.getUgNo();
        this.title = entity.getName();
        this.registDate = entity.getRegistDate();
        this.dueDate = entity.getDueDate();
    }
}
