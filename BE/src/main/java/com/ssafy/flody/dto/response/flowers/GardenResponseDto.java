package com.ssafy.flody.dto.response.flowers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.flowers.gardens.Gardens;
import lombok.Getter;

import java.util.Calendar;
import java.util.Date;

@Getter
public class GardenResponseDto {
    private Long garNo;
    private String name;
    private String url;
    private int exp;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public GardenResponseDto(Gardens entity){
        this.garNo = entity.getGarNo();
        this.name = entity.getFlower().getName();
        this.url = entity.getFlower().getUrl();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getStartDate());
        cal.add(Calendar.DATE, 1);
        this.startDate = cal.getTime();
        if (entity.getEndDate() != null) {
            cal.setTime(entity.getEndDate());
            cal.add(Calendar.DATE, 1);
            this.endDate = cal.getTime();
        }
        this.exp = entity.getExp();
    }
}
