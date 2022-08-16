package com.ssafy.flody.service.groups.goals;

import com.ssafy.flody.dto.request.groups.GroupGoalCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupGoalUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupGoalResponseDto;

import java.util.List;
import java.util.Optional;

public interface GroupGoalService {

    //해당 그룹의 전체 goal 목록
    public List<GroupGoalResponseDto> findAllGroupGoals(Long groNo);

    //해당 그룹 개별 goal
    public GroupGoalResponseDto findGroupGoal(Long ggNo);

    //C
    public String addGroupGoal(Long groNo, String email, GroupGoalCreateRequestDto requestDto) throws Exception;
    //U
    public Long modifyGroupGoal(Long ggNo, GroupGoalUpdateRequestDto requestDto) throws Exception;
    //D
    public Long removeGroupGoal(Long ggNo);
}
