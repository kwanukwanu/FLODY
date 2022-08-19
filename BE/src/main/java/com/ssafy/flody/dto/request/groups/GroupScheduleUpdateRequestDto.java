package com.ssafy.flody.dto.request.groups;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Date;

@Getter
@NoArgsConstructor
public class GroupScheduleUpdateRequestDto {
    @Nullable
    private String title;
    @Nullable
    private String detail;
    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @Nullable
    private Boolean done;
}
