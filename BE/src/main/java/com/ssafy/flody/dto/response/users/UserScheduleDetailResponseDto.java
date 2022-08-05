package com.ssafy.flody.dto.response.users;

import com.ssafy.flody.domain.users.schedules.USchedules;
import lombok.Getter;

import java.util.Date;

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
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.done = entity.getDone();
    }

}
