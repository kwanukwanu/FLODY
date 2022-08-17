package com.ssafy.flody.dto.request.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserGoalUpdateRequestDto {
    @Nullable
    private String name;
    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
}
