package com.ssafy.flody.dto.response.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.users.schedules.USchedules;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Getter
public class UserScheduleListResponseDto {
    private Long usNo;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
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
