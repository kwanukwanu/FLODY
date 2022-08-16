package com.ssafy.flody.dto.response.groups;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Getter;

import java.util.Date;

@Getter
public class GroupScheduleDetailResponseDto {
    private Long gsNo;
    private String title;
    private String detail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Boolean done;

    public GroupScheduleDetailResponseDto(GSchedules entity){
        this.gsNo = entity.getGsNo();
        this.title = entity.getTitle();
        this.detail = entity.getDetail();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.done = entity.getDone();
    }
}
