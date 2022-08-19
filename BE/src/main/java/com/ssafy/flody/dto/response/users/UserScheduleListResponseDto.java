package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.schedules.USchedules;
import lombok.Getter;

import java.util.Date;
import java.util.TimeZone;

@Getter
public class UserScheduleListResponseDto {
    //private Long useNo;
    private String title;
    private Date startDate;
    private Date endDate;
    private Boolean done;

    public UserScheduleListResponseDto(USchedules entity){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        this.usNo = entity.getUsNo();
        this.title = entity.getTitle();
        cal.setTime(entity.getStartDate());
        this.startDate = cal.getTime();
        cal.setTime(entity.getEndDate());
        this.endDate = cal.getTime();
        this.done = entity.getDone();
    }
}
