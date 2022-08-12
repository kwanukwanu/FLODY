package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupMemberUpdateRequestDto {
    private Long gmNo;
    private String role;

    @Builder
    public GroupMemberUpdateRequestDto(Long gmNo, String role) {
        this.gmNo = gmNo;
        this.role = role;
    }

    public GMembers toEntity(Long gmNo, Users user, Groups group, GRoles role){
        return GMembers.builder()
                .gmNo(gmNo)
                .user(user)
                .group(group)
                .role(role)
                .build();
    }
}
