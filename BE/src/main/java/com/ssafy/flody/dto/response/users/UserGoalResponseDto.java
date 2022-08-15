package com.ssafy.flody.dto.response.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.users.goals.UGoals;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getRegistDate());
        cal.add(Calendar.DATE, 1);
        this.registDate = cal.getTime();
        cal.setTime(entity.getDueDate());
        cal.add(Calendar.DATE, 1);
        this.dueDate = cal.getTime();
    }
}
