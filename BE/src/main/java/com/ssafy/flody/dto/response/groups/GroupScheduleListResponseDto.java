package com.ssafy.flody.dto.response.groups;

import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Getter;

import java.util.Date;

@Getter
public class GroupScheduleListResponseDto {
    private Long gsNo;
    private String title;
    private Date startDate;
    private Date endDate;
    private Boolean done;

    public GroupScheduleListResponseDto(GSchedules entity){
        this.gsNo = entity.getGsNo();
        this.title = entity.getTitle();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.done = entity.getDone();
    }
}
