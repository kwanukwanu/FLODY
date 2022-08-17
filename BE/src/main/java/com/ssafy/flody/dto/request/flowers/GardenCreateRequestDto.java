package com.ssafy.flody.dto.request.flowers;

import com.ssafy.flody.domain.flowers.Flowers;
import com.ssafy.flody.domain.flowers.gardens.Gardens;
import com.ssafy.flody.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GardenCreateRequestDto {
    private Integer exp = 0;

    // DTO to ENTITY
    public Gardens toEntity(Flowers flower, Users user){
        return Gardens.builder()
                .flower(flower)
                .user(user)
                .exp(exp)
                .build();
    }
}
