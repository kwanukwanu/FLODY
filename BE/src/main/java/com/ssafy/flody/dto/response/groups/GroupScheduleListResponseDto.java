package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Getter;

import java.util.Date;

@Getter
public class GroupScheduleListResponseDto {
    private String title;
    private Date startDate;
    private Date endDate;
    private Boolean done;

    public GroupScheduleListResponseDto(GSchedules entity){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        this.gsNo = entity.getGsNo();
        this.title = entity.getTitle();
        cal.setTime(entity.getStartDate());
        this.startDate = cal.getTime();
        cal.setTime(entity.getEndDate());
        this.endDate = cal.getTime();
        this.done = entity.getDone();
    }
}
