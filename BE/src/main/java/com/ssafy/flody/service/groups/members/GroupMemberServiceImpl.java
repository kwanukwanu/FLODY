package com.ssafy.flody.service.groups.members;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.GroupsRepository;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.groups.members.GMembersRepository;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.groups.roles.GRolesRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.groups.GroupMemberCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupMemberUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupMemberDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GMembersRepository groupMemberRepository;
    private final UsersRepository userRepository;
    private final GroupsRepository groupRepository;
    private final GRolesRepository roleRepository;

    public List<GroupMemberDetailResponseDto> findMembers(Long groNo) {
        Groups group = findGroup(groNo);
        List<GMembers> entityList = groupMemberRepository.findAllByGroup(group);
        List<GroupMemberDetailResponseDto> list = new ArrayList<>();
        for (GMembers member : entityList) {
            list.add(new GroupMemberDetailResponseDto(member));
        }
        return list;
    }

    public GroupMemberDetailResponseDto findMember(Long gmNo) {
        return new GroupMemberDetailResponseDto(groupMemberRepository.findById(gmNo)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found")));
    }

    public String addMember(String email, GroupMemberCreateRequestDto requestDto) throws Exception {
        if (!email.equals(requestDto.getEmail())) {
            if (!isValid(email, requestDto.getGroNo()))
                throw new Exception("User Unqualified");
        }
        GMembers groupMember = GMembers.builder()
                .user(findUser(requestDto.getEmail()))
                .group(findGroup(requestDto.getGroNo()))
                .role(findRole(requestDto.getRole()))
                .build();
        return groupMemberRepository.save(groupMember).getUser().getEmail();
    }

    public String modifyMember(String email, GroupMemberUpdateRequestDto requestDto) throws Exception {
        GMembers member = groupMemberRepository.findById(requestDto.getGmNo())
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found"));
        GRoles role = findRole(requestDto.getRole());
        if (!isValid(email, member.getGroup().getGroNo())) {
            throw new Exception("User Unqualified");
        }
        member.update(role);
        return groupMemberRepository.save(member).getUser().getName();
    }

    public String removeMember(String email, Long gmNo) throws Exception {
        GMembers member = groupMemberRepository.findById(gmNo)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found"));
        if (!email.equals(member.getUser().getEmail())) {
            if (!isValid(email, member.getGroup().getGroNo())) {
                throw new Exception("User Unqualified");
            }
        }
        groupMemberRepository.delete(member);
        return email;
    }

    public Long removeAllMembers(Long groNo) throws Exception {
        List<GMembers> members = groupMemberRepository.findAllByGroup(findGroup(groNo));
        for (GMembers member : members) {
            groupMemberRepository.delete(member);
        }
        return groNo;
    }

    public Boolean isValid(String email, Long groNo) {
        Users user = findUser(email);
        Groups group = findGroup(groNo);
        return !groupMemberRepository.findByUserAndGroup(user, group)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found"))
                .getRole().getName().equals("MEMBER");
    }

    public Users findUser(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("Group Not Found"));
    }

    public Groups findGroup(Long groNo) {
        return groupRepository.findById(groNo)
                .orElseThrow(() -> new IllegalArgumentException("Group Not Found"));
    }

    public GRoles findRole(String role) {
        return roleRepository.findByName(role)
                .orElseThrow(() -> new IllegalArgumentException("Group Not Found"));
    }
}
