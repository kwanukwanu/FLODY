package com.ssafy.flody.dto.response.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.users.schedules.USchedules;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
public class UserScheduleListResponseDto {
    //private Long useNo;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Boolean done;

    public UserScheduleListResponseDto(USchedules entity){
        this.title = entity.getTitle();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.done = entity.getDone();
    }
}
