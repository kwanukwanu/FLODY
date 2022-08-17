package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.goals.GGoals;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Getter
@NoArgsConstructor
public class GroupGoalCreateRequestDto {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registDate = findToday();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    //DTO to Entity
    public GGoals toEntity(Groups group){
        return GGoals.builder()
                .group(group)
                .name(name)
                .registDate(registDate)
                .dueDate(dueDate)
                .build();
    }

    private Date findToday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
}
