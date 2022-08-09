package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.goals.GGoals;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@NoArgsConstructor
public class GroupGoalCreateRequestDto {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    @Builder
    public GroupGoalCreateRequestDto(String name, Date dueDate){
        this.name = name;
        this.dueDate = dueDate;
    }

    //DTO to Entity
    public GGoals toEntity(Groups group){
        return GGoals.builder()
                .group(group)
                .name(name)
                .dueDate(dueDate)
                .build();
    }
}
