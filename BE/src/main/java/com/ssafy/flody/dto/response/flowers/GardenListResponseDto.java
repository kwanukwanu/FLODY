package com.ssafy.flody.dto.response.flowers;

import com.ssafy.flody.domain.flowers.gardens.Gardens;
import lombok.Getter;

import java.util.Date;

@Getter
public class GardenListResponseDto {
    private int exp;
    private Date startDate;
    private Date endDate;

    public GardenListResponseDto(Gardens entity){
        this.exp = entity.getExp();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
    }
}
