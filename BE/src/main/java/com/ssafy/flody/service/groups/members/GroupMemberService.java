package com.ssafy.flody.service.groups.members;

import com.ssafy.flody.dto.request.groups.GroupMemberCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupMemberUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupMemberDetailResponseDto;

import java.util.List;

public interface GroupMemberService {
    public List<GroupMemberDetailResponseDto> findMembers(Long groNo);
    public GroupMemberDetailResponseDto findMember(Long gmNo);
    public String addMember(String email, GroupMemberCreateRequestDto requestDto) throws Exception;
    public String modifyMember(String email, GroupMemberUpdateRequestDto requestDto) throws Exception;
    public String removeMember(String email, Long gmNo) throws Exception;
    public Long removeAllMembers(Long groNo) throws Exception;
    public Boolean isValid(String email, Long groNo);
}
