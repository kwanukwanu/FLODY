package com.ssafy.flody.service.groups.goals;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.GroupsRepository;
import com.ssafy.flody.domain.groups.goals.GGoals;
import com.ssafy.flody.domain.groups.goals.GGoalsRepository;
import com.ssafy.flody.domain.groups.members.GMembers;
import com.ssafy.flody.domain.groups.members.GMembersRepository;
import com.ssafy.flody.domain.groups.roles.GRoles;
import com.ssafy.flody.domain.groups.roles.GRolesRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.groups.GroupGoalCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupGoalUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupGoalResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupGoalServiceImpl  implements GroupGoalService{
    private final GGoalsRepository groupgoalsRepository;
    private final GroupsRepository groupsRepository;

    private final GMembersRepository groupMemberRepository;
    private final UsersRepository usersRepository;

    private final GRolesRepository rolesRepository;

    public List<GroupGoalResponseDto> findAllGroupGoals(Long groNo){
        Groups group = findGroup(groNo);
        List<GGoals> entityList = groupgoalsRepository.findAllByGroup(group);
        List<GroupGoalResponseDto> list = new ArrayList<>();
        for (GGoals goals : entityList){
            list.add(new GroupGoalResponseDto(goals));
        }
        return list;
    }

    public GroupGoalResponseDto findGroupGoal(Long ggNo) {
        return new GroupGoalResponseDto(groupgoalsRepository.findById(ggNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다.")));
    }

    public String addGroupGoal(Long groNo, String email, GroupGoalCreateRequestDto requestDto) throws Exception{
        if (isValid(email,groNo)){
            return groupgoalsRepository.save(requestDto.toEntity(findGroup(groNo))).getName();
        }else {
            return null;
        }
    }

    public Long modifyGroupGoal(Long ggNo, GroupGoalUpdateRequestDto requestDto ) throws Exception{
        GGoals goals = groupgoalsRepository.findById(ggNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다."));
        goals.update(
                requestDto.getName(),
                requestDto.getDueDate()
        );
        return groupgoalsRepository.save(goals).getGgNo();
    }

    public Long removeGroupGoal(Long ggNo){
        groupgoalsRepository.delete(groupgoalsRepository.findById(ggNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다.")));
        return ggNo;
    }

    public Boolean isValid(String email, Long groNo) {
        Users user = findUser(email);
        Groups group = findGroup(groNo);
        GMembers members = groupMemberRepository.findByUserAndGroup(user,group)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다."));
        if (!members.getRole().equals("MEMBER")){
            return true;
        }else {
            return false;
        }
    }
    public Groups findGroup(Long groNo){
        return groupsRepository.findById(groNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다."));
    }

    public Users findUser(String email){
        return usersRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다."));
    }

    public GRoles findRoles(String role){
        return rolesRepository.findByName(role)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 존재하지 않습니다."));
    }
}
