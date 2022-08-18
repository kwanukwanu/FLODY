package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.domain.groups.schedules.GSchedules;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Getter
@NoArgsConstructor
public class GroupScheduleCreateRequestDto {
    private String title;
    @Nullable
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    private Date findToday() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(new Date(System.currentTimeMillis()));
        return cal.getTime();
    }
}
