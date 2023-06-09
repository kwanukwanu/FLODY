package com.ssafy.flody.service.users.goals;

import com.ssafy.flody.dto.request.users.UserGoalCreateRequestDto;
import com.ssafy.flody.dto.request.users.UserGoalUpdateRequestDto;
import com.ssafy.flody.dto.response.users.UserGoalResponseDto;

import java.util.List;

public interface UGoalService {
    public List<UserGoalResponseDto> findUserGoals(String token) throws Exception;
    public UserGoalResponseDto findUserGoal(Long ugNo);
    public Long addUserGoal(String email, UserGoalCreateRequestDto requestDto);
    public Long modifyUserGoal(Long ugNo, UserGoalUpdateRequestDto requestDto);
    public Long removeUserGoal(Long ugNo);
}
