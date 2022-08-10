package com.ssafy.flody.dto.response.groups;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.groups.Groups;
import lombok.Getter;

import java.util.Date;

@Getter
public class GroupDetailResponseDto {
    private Long groNo;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date foundDate;

    public GroupDetailResponseDto(Groups entity){
        this.groNo = entity.getGroNo();
        this.name = entity.getName();
        this.foundDate = entity.getFoundDate();
    }
}
