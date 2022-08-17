package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class GroupScheduleCreateRequestDto {
    private String title;
    private String detail;
    private Date startDate;
    private Date endDate;
    private Boolean done = false;

    @Builder
    public GroupScheduleCreateRequestDto(String title, String detail, Date startDate, Date endDate){
        this.title = title;
        this.detail = detail;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //DTO to Entity
    public GSchedules toEntity(Groups group){
        return GSchedules.builder()
                .group(group)
                .title(title)
                .detail(detail)
                .startDate(startDate)
                .endDate(endDate)
                .done(done)
                .build();
    }
}
