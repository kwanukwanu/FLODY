package com.ssafy.flody.dto.request.users;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.goals.UGoals;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Getter
@NoArgsConstructor
public class UserGoalCreateRequestDto {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registDate = new Date(System.currentTimeMillis());
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public UGoals toEntity(Users user) {
        return UGoals.builder()
                .user(user)
                .name(name)
                .registDate(registDate)
                .dueDate(dueDate)
                .build();
    }

//    private Date findToday() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date(System.currentTimeMillis()));
//        cal.add(Calendar.DATE, 1);
//        return cal.getTime();
//    }
}
