package com.ssafy.flody.service.users.schedule;

import com.ssafy.flody.domain.users.schedules.USchedules;
import com.ssafy.flody.domain.users.schedules.USchedulesRepository;
import com.ssafy.flody.dto.request.Users.UserScheduleCreateRequestDto;
import com.ssafy.flody.dto.request.Users.UserScheduleUpdateRequestDto;
import com.ssafy.flody.dto.response.Users.UserScheduleDetailResponseDto;
import com.ssafy.flody.dto.response.Users.UserScheduleListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UScheduleServiceImpl implements UScheduleService {
    private final USchedulesRepository userScheduleRepository;

    @Transactional
    public List<UserScheduleListResponseDto> findAllUserSchedule(Long useNo) {
        List<USchedules> entityList = userScheduleRepository.findAll();
        List<UserScheduleListResponseDto> list = new ArrayList<>();
        for (USchedules uSchedules: entityList) {
            list.add(new UserScheduleListResponseDto(uSchedules));
        }
        return list;
    }

    @Transactional
    public UserScheduleDetailResponseDto findUserSchedule(Long usNo) {
        return new UserScheduleDetailResponseDto(userScheduleRepository.findById(usNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found")));
    }

    @Transactional
    public Long addUserSchedule(UserScheduleCreateRequestDto requestDto) {
        return userScheduleRepository.save(requestDto.toEntity()).getUsNo();
    }

    @Transactional
    public Long modifyUserSchedule(Long usNo, UserScheduleUpdateRequestDto requestDto) {
        USchedules uSchedules = userScheduleRepository.findById(usNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found"));
        uSchedules.update(requestDto.getTitle()
                        , requestDto.getDetail()
                        , requestDto.getStartDate()
                        , requestDto.getEndDate()
                        , requestDto.getDone()
        );
        return usNo;
    }

    @Transactional
    public Long removeUserSchedule(Long usNo) {
        userScheduleRepository.delete(userScheduleRepository.findById(usNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found")));
        return usNo;
    }
}
