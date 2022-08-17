package com.ssafy.flody.service.users.schedules;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.domain.users.schedules.USchedules;
import com.ssafy.flody.domain.users.schedules.USchedulesRepository;
import com.ssafy.flody.dto.request.users.UserScheduleCreateRequestDto;
import com.ssafy.flody.dto.request.users.UserScheduleUpdateRequestDto;
import com.ssafy.flody.dto.response.users.UserScheduleDetailResponseDto;
import com.ssafy.flody.dto.response.users.UserScheduleListResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unchecked") // type unchecked error 발생하는거 안보여줌. 좋은 방법은 아님.
public class UScheduleServiceImpl implements UScheduleService {
    private final USchedulesRepository userScheduleRepository;
    private final UsersRepository usersRepository;

    @Transactional
    public List<UserScheduleListResponseDto> findUserSchedules(String email) throws Exception {
        Users user = findUser(email);
        List<USchedules> entityList = userScheduleRepository.findAllByUser(user);
        List<UserScheduleListResponseDto> list = new ArrayList<>();
        for (USchedules uSchedules : entityList) {
            list.add(new UserScheduleListResponseDto(uSchedules));
        }
        return list;
    }
    public List<UserScheduleListResponseDto> findUserDaySchedules(String email, Date date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        Date from = cal.getTime();
        System.out.println(from);
        cal.add(Calendar.DATE, -2);
        Date upto = cal.getTime();
        System.out.println(upto);
        List<USchedules> entityList = userScheduleRepository.findAllByUserAndStartDateBeforeAndEndDateAfter(findUser(email), from, upto);
        List<UserScheduleListResponseDto> list = new ArrayList<>();
        for (USchedules schedule : entityList) {
            list.add(new UserScheduleListResponseDto(schedule));
        }
        return list;
    }
    public List<UserScheduleListResponseDto> findUserMonthSchedules(String email, Date date) {
        System.out.println(date);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        Date from = cal.getTime();
        System.out.println(from);
        cal.add(Calendar.MONTH, -1);
        cal.add(Calendar.DATE, -1);
        Date upto = cal.getTime();
        System.out.println(upto);
        List<USchedules> entityList = userScheduleRepository.findAllByUserAndStartDateBeforeAndEndDateAfter(findUser(email), from, upto);
        List<UserScheduleListResponseDto> list = new ArrayList<>();
        for (USchedules schedule : entityList) {
            list.add(new UserScheduleListResponseDto(schedule));
        }
        return list;
    }

    @Transactional
    public UserScheduleDetailResponseDto findUserSchedule(Long usNo) {
        return new UserScheduleDetailResponseDto(userScheduleRepository.findById(usNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found")));
    }

    @Transactional
    public Long addUserSchedule(String email, UserScheduleCreateRequestDto requestDto) {
        return userScheduleRepository.save(requestDto.toEntity(findUser(email))).getUsNo();
    }

    @Transactional
    public Long modifyUserSchedule(Long usNo, UserScheduleUpdateRequestDto requestDto) {
        USchedules uSchedules = userScheduleRepository.findById(usNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found"));
        uSchedules.update(requestDto.getTitle(),
                requestDto.getDetail(),
                requestDto.getStartDate(),
                requestDto.getEndDate(),
                requestDto.getDone()
        );
        return userScheduleRepository.save(uSchedules).getUsNo();
    }

    @Transactional
    public Long removeUserSchedule(Long usNo) {
        USchedules schedule = userScheduleRepository.findById(usNo)
                        .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found"));
        userScheduleRepository.delete(schedule);
        return usNo;
    }

    public Users findUser(String email) {
        return usersRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }
}
