package com.ssafy.flody.dto.request.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserGoalUpdateRequestDto {
    private String name;
    private Date registDate;
    private Date dueDate;

    @Builder
    public UserGoalUpdateRequestDto(String name, Date registDate, Date dueDate){
        this.name = name;
        this.registDate = registDate;
        this.dueDate = dueDate;
    }
}
