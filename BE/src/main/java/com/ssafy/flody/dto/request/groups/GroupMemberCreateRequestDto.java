package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupMemberCreateRequestDto {
    public GMembers toEntity(Users user, Groups group, GRoles role){
        return GMembers.builder()
                .user(user)
                .group(group)
                .role(role)
                .build();
    }
}
