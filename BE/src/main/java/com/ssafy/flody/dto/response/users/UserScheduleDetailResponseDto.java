package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.schedules.USchedules;
import lombok.Getter;

import java.util.Date;
import java.util.TimeZone;

@Getter
public class UserScheduleDetailResponseDto {
    private String title;
    private String detail;
    private Date startDate;
    private Date endDate;
    private Boolean done;

    public UserScheduleDetailResponseDto(USchedules entity){
        this.title = entity.getTitle();
        this.detail = entity.getDetail();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(entity.getStartDate());
        this.startDate = cal.getTime();
        cal.setTime(entity.getEndDate());
        this.endDate = cal.getTime();
        this.done = entity.getDone();
    }

}
