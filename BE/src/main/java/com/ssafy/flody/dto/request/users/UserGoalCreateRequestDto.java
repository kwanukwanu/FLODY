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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @Builder
    public UserGoalCreateRequestDto(String name, Date registDate, Date dueDate) {
        this.name = name;
        this.registDate = registDate;
        this.dueDate = dueDate;
    }

    public UGoals toEntity(Users user) {
        return UGoals.builder()
                .user(user)
                .name(name)
                .registDate(registDate)
                .dueDate(dueDate)
                .build();
    }
}
