package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.members.GMembers;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupMemberDetailResponseDto {
    Long gmNo;
    String email;
    String role;

    public GroupMemberDetailResponseDto(GMembers member) {
        this.gmNo = member.getGmNo();
        this.email = member.getUser().getEmail();
        this.role = member.getRole().getName();
    }
}
