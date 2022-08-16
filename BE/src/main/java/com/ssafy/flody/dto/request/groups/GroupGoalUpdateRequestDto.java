package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.goals.GGoals;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.users.Users;
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
    private Date dueDate;

    @Builder
    public GroupGoalUpdateRequestDto(String name, Date dueDate
    ){
        this.name = name;
        this.dueDate = dueDate;
    }

    public GGoals toEntity(Groups group){
        return GGoals.builder()
                .group(group)
                .name(name)
                .dueDate(dueDate)
                .build();
    }
}
