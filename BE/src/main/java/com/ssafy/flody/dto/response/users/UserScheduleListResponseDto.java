package com.ssafy.flody.dto.response.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.users.schedules.USchedules;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

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
        Calendar cal = Calendar.getInstance();
        this.usNo = entity.getUsNo();
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
