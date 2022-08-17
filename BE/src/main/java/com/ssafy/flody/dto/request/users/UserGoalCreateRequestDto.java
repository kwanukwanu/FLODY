package com.ssafy.flody.dto.request.users;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.goals.UGoals;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserGoalCreateRequestDto {
    private String name;

    private Date dueDate;
    @Builder
    public UserGoalCreateRequestDto(String name, Date dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public UGoals toEntity(Users user){
        return UGoals.builder()
                .user(user)
                .name(name)
                .dueDate(dueDate)
                .build();
    }
}
