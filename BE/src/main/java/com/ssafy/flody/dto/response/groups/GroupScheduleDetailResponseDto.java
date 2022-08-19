package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Getter;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Getter
public class GroupScheduleDetailResponseDto {
    private String title;
    private String detail;
    private Date startDate;
    private Date endDate;
    private Boolean done;

    public GroupScheduleDetailResponseDto(GSchedules entity){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        this.gsNo = entity.getGsNo();
        this.title = entity.getTitle();
        this.detail = entity.getDetail();
        cal.setTime(entity.getStartDate());
        this.startDate = cal.getTime();
        cal.setTime(entity.getEndDate());
        this.endDate = cal.getTime();
        this.done = entity.getDone();
    }
}
