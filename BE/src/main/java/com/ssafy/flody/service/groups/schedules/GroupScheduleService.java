package com.ssafy.flody.service.groups.schedules;

        import com.ssafy.flody.dto.request.groups.GroupScheduleCreateRequestDto;
        import com.ssafy.flody.dto.request.groups.GroupScheduleUpdateRequestDto;
        import com.ssafy.flody.dto.response.groups.GroupScheduleDetailResponseDto;
        import com.ssafy.flody.dto.response.groups.GroupScheduleListResponseDto;

        import java.util.Date;
        import java.util.List;

public interface GroupScheduleService {
    public List<GroupScheduleListResponseDto> findAllGroupSchedules(Long groNo) throws Exception;
    public List<GroupScheduleListResponseDto> findGroupDaySchedules(Long groNo, Date date);
    public List<GroupScheduleListResponseDto> findGroupMonthSchedules(Long groNo, Date date);
    public GroupScheduleDetailResponseDto findGroupSchedule(Long gsNo);
    public String addGroupSchedule(Long groNo, GroupScheduleCreateRequestDto requestDto) throws Exception;
    public Long modifyGroupSchedule(Long gsNo, GroupScheduleUpdateRequestDto requestDto) throws Exception;
    public Long removeGroupSchedule(Long gsNo);
}
