package com.ssafy.flody.dto.request.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@NoArgsConstructor
public class GroupGoalUpdateRequestDto {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @Builder
    public GroupGoalUpdateRequestDto(String name, Date registDate, Date dueDate
    ){
        this.name = name;
        this.registDate = registDate;
        this.dueDate = dueDate;
    }
}
