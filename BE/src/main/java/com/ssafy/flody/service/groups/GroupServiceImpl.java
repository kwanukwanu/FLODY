package com.ssafy.flody.service.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.GroupsRepository;
import com.ssafy.flody.domain.groups.members.GMembersRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.dto.request.groups.GroupCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupDetailResponseDto;
import com.ssafy.flody.dto.response.users.UserInfoResponseDto;
import com.ssafy.flody.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupsRepository groupRepository;

    @Transactional
    public List<GroupDetailResponseDto> findGroups() {
        List<Groups> entityList = groupRepository.findAll();
        List<GroupDetailResponseDto> list = new ArrayList<>();
        for (Groups group: entityList) {
            list.add(new GroupDetailResponseDto(group));
        }
        return list;
    };

    @Transactional
    public GroupDetailResponseDto findGroupById(Long groNo) {
        return new GroupDetailResponseDto(findGroup(groNo));
    };

    @Transactional
    public Long addGroup(GroupCreateRequestDto requestDto) {
        return groupRepository.save(requestDto.toEntity()).getGroNo();
    };

    @Transactional
    public Long modifyGroup(Long groNo, GroupUpdateRequestDto requestDto) {
        Groups group = findGroup(groNo);
        group.update(
                requestDto.getName()
        );
        return groupRepository.save(group).getGroNo();
    };

    @Transactional
    public Long removeGroup(Long groNo) {
        Groups group = findGroup(groNo);
        groupRepository.delete(group);
        return group.getGroNo();
    };

    private Groups findGroup(Long groNo) {
        return groupRepository.findById(groNo)
                .orElseThrow(() -> new IllegalArgumentException(groNo +"은(는) 존재하지 않는 그룹입니다."));
    }
}
