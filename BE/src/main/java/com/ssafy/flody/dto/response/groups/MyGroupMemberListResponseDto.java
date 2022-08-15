package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.Groups;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MyGroupMemberListResponseDto {
    private Long groNo;
    private String groName;
    private List<GroupMemberDetailResponseDto> memberList;

    public MyGroupMemberListResponseDto(Groups group, List<GroupMemberDetailResponseDto> list) {
        this.groNo = group.getGroNo();
        this.groName = group.getName();
        this.memberList = list;
    }
}