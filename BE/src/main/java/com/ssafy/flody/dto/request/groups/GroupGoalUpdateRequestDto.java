package com.ssafy.flody.dto.request.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class GroupGoalUpdateRequestDto {
    private String name;
    private Date registDate;
    private Date dueDate;

    @Builder
    public GroupGoalUpdateRequestDto(String name, Date registDate, Date dueDate
    ){
        this.name = name;
        this.registDate = registDate;
        this.dueDate = dueDate;
    }
}
