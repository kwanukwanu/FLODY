package com.ssafy.flody.dto.response.groups;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Getter;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Getter
public class GroupScheduleListResponseDto {
    private Long gsNo;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Boolean done;

    public GroupScheduleListResponseDto(GSchedules entity){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));

        this.gsNo = entity.getGsNo();
        this.title = entity.getTitle();
        cal.setTime(entity.getStartDate());
        cal.add(Calendar.DATE, 1);
        this.startDate = cal.getTime();
        cal.setTime(entity.getEndDate());
        cal.add(Calendar.DATE, 1);
        this.endDate = cal.getTime();
        this.done = entity.getDone();
    }
}
