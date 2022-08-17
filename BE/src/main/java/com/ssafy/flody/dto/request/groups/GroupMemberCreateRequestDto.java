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
public class GroupMemberCreateRequestDto {
    private String email;
    private Long groNo;
    private String role = "MEMBER";

    @Builder
    public GroupMemberCreateRequestDto(String email, Long groNo, String role) {
        this.email = email;
        this.groNo = groNo;
        this.role = role;
    }

    public GMembers toEntity(Users user, Groups group, GRoles role){
        return GMembers.builder()
                .user(user)
                .group(group)
                .role(role)
                .build();
    }
}
