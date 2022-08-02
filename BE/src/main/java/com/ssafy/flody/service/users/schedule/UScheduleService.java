package com.ssafy.flody.service.users.schedule;

import com.ssafy.flody.dto.request.Users.UserScheduleCreateRequestDto;
import com.ssafy.flody.dto.request.Users.UserScheduleUpdateRequestDto;
import com.ssafy.flody.dto.response.Users.UserScheduleDetailResponseDto;
import com.ssafy.flody.dto.response.Users.UserScheduleListResponseDto;

import java.util.List;

public interface UScheduleService {
    public List<UserScheduleListResponseDto> findAllUserSchedule(Long useNo);
    public UserScheduleDetailResponseDto findUserSchedule(Long usNo);
    public Long addUserSchedule(UserScheduleCreateRequestDto requestDto);
    public Long modifyUserSchedule(Long usNo, UserScheduleUpdateRequestDto requestDto);
    public Long removeUserSchedule(Long usNo);
}
