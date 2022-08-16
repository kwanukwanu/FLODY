package com.ssafy.flody.dto.request.flowers;

import com.ssafy.flody.domain.flowers.Flowers;
import com.ssafy.flody.domain.flowers.gardens.Gardens;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@NoArgsConstructor
public class GardenCreateRequestDto {
    private String name = "1단계";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate = new Date(System.currentTimeMillis());
    private int exp = 0;

    // DTO to ENTITY
    public Gardens toEntity(Flowers flower, Users user){
        return Gardens.builder()
                .flower(flower)
                .user(user)
                .startDate(startDate)
                .endDate(null)
                .exp(exp)
                .build();
    }
}
