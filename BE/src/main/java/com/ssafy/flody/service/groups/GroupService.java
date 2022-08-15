package com.ssafy.flody.service.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.dto.request.groups.GroupCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupDetailResponseDto;

import java.util.List;

public interface GroupService {
    public List<GroupDetailResponseDto> findGroups();
    public GroupDetailResponseDto findGroupById(Long groNo);
    public Long addGroup(GroupCreateRequestDto requestDto);
    public Long modifyGroup(GroupUpdateRequestDto requestDto);
    public Long removeGroup(Long groNo);
    public List<Groups> findMyGroups(String email) throws Exception;
    public List<GroupDetailResponseDto> findGroupsByName(String keyword) throws Exception;
}
