package com.ssafy.flody.dto.response.groups;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.groups.Groups;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Calendar;
import java.util.Date;

@Getter
public class GroupDetailResponseDto {
    private Long groNo;
    private String name;
    @Nullable
    private String introduction;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date foundDate;

    public GroupDetailResponseDto(Groups entity){
        this.groNo = entity.getGroNo();
        this.name = entity.getName();
        this.introduction = entity.getIntroduction();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getFoundDate());
        cal.add(Calendar.DATE, 1);
        this.foundDate = cal.getTime();
    }
}
