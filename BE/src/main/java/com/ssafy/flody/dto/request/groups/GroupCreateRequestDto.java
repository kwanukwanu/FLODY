package com.ssafy.flody.dto.request.groups;

import com.ssafy.flody.domain.groups.Groups;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Calendar;
import java.util.Date;

//스터디 구성원(many to many table)에서 진행? 뭐가 맞는지 모르겠습니당
@Getter
@NoArgsConstructor
public class GroupCreateRequestDto {
    private String name;
    @Nullable
    private String introduction;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date foundDate = new Date(System.currentTimeMillis());

    @Builder
    public GroupCreateRequestDto(String name, String introduction, Date foundDate) {
        this.name = name;
        this.introduction = introduction;
        this.foundDate = foundDate;
    }

    public Groups toEntity(){
        return Groups.builder()
                .name(name)
                .introduction(introduction)
                .foundDate(foundDate)
                .build();
    }
//    private Date findToday() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date(System.currentTimeMillis()));
//        cal.add(Calendar.DATE, 1);
//        return cal.getTime();
//    }
}
