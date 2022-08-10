package com.ssafy.flody.dto.request.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserGoalUpdateRequestDto {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @Builder
    public UserGoalUpdateRequestDto(String name, Date dueDate){
        this.name = name;
        this.dueDate = dueDate;
    }
}
