package com.ssafy.flody.service.groups.schedules;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.GroupsRepository;
import com.ssafy.flody.domain.groups.goals.GGoals;
import com.ssafy.flody.domain.groups.schedules.GSchedules;
import com.ssafy.flody.domain.groups.schedules.GSchedulesRepository;
import com.ssafy.flody.domain.users.schedules.USchedules;
import com.ssafy.flody.dto.request.groups.GroupGoalCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupGoalUpdateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupScheduleCreateRequestDto;
import com.ssafy.flody.dto.request.groups.GroupScheduleUpdateRequestDto;
import com.ssafy.flody.dto.response.groups.GroupGoalResponseDto;
import com.ssafy.flody.dto.response.groups.GroupScheduleDetailResponseDto;
import com.ssafy.flody.dto.response.groups.GroupScheduleListResponseDto;
import com.ssafy.flody.dto.response.users.UserScheduleListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GroupScheduleServiceImpl implements GroupScheduleService{

    private final GSchedulesRepository groupSchedulerepository;
    private final GroupsRepository groupsRepository;


    public List<GroupScheduleListResponseDto> findAllGroupSchedules(Long groNo){
        Groups group = findGroup(groNo);
        List<GSchedules> entityList = groupSchedulerepository.findAllByGroup(group);
        List<GroupScheduleListResponseDto> list = new ArrayList<>();
        for (GSchedules schedule : entityList){
            list.add(new GroupScheduleListResponseDto(schedule));
        }
        return list;
    }

    public List<GroupScheduleListResponseDto> findGroupDaySchedules(Long groNo, Date date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        Date from = cal.getTime();
        System.out.println(from);
        cal.add(Calendar.DATE, -2);
        Date upto = cal.getTime();
        System.out.println(upto);
        List<GSchedules> entityList = groupSchedulerepository.findAllByGroupAndStartDateBeforeAndEndDateAfter(findGroup(groNo), from, upto);
        List<GroupScheduleListResponseDto> list = new ArrayList<>();
        for (GSchedules schedule : entityList) {
            list.add(new GroupScheduleListResponseDto(schedule));
        }
        return list;
    }
    public List<GroupScheduleListResponseDto> findGroupMonthSchedules(Long groNo, Date date) {
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
        List<GSchedules> entityList = groupSchedulerepository.findAllByGroupAndStartDateBeforeAndEndDateAfter(findGroup(groNo), from, upto);
        List<GroupScheduleListResponseDto> list = new ArrayList<>();
        for (GSchedules schedule : entityList) {
            list.add(new GroupScheduleListResponseDto(schedule));
        }
        return list;
    }

    public GroupScheduleDetailResponseDto findGroupSchedule(Long gsNo) {
        return new GroupScheduleDetailResponseDto(groupSchedulerepository.findById(gsNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다.")));
    }

    public String addGroupSchedule(Long groNo, GroupScheduleCreateRequestDto requestDto) throws Exception{
        return groupSchedulerepository.save(requestDto.toEntity(findGroup(groNo))).getTitle();
    }

    public Long modifyGroupSchedule(Long gsNo, GroupScheduleUpdateRequestDto requestDto ) throws Exception{
        GSchedules schedules = groupSchedulerepository.findById(gsNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다."));
        schedules.update(
                requestDto.getTitle(),
                requestDto.getDetail(),
                requestDto.getStartDate(),
                requestDto.getEndDate(),
                requestDto.getDone()
        );
        return groupSchedulerepository.save(schedules).getGsNo();
    }

    public Long removeGroupSchedule(Long gsNo){
        groupSchedulerepository.delete(groupSchedulerepository.findById(gsNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다.")));
        return gsNo;
    }

    public Groups findGroup(Long groNo){
        return groupsRepository.findById(groNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다."));
    }
}
