package com.ssafy.flody.service.users.schedules;

import com.ssafy.flody.dto.request.users.UserScheduleCreateRequestDto;
import com.ssafy.flody.dto.request.users.UserScheduleUpdateRequestDto;
import com.ssafy.flody.dto.response.users.UserScheduleDetailResponseDto;
import com.ssafy.flody.dto.response.users.UserScheduleListResponseDto;

import java.util.List;

public interface UScheduleService {
    public List<UserScheduleListResponseDto> findUserSchedules(String email) throws Exception;
    public UserScheduleDetailResponseDto findUserSchedule(Long usNo);
    public Long addUserSchedule(String email, UserScheduleCreateRequestDto requestDto);
    public Long modifyUserSchedule(Long usNo, UserScheduleUpdateRequestDto requestDto);
    public Long removeUserSchedule(Long usNo);
}
