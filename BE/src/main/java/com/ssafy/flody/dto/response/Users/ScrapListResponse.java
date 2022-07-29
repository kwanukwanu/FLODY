package com.ssafy.flody.dto.response.Users;

import com.ssafy.flody.domain.boards.scraps.Scraps;
import lombok.Getter;

@Getter
public class ScrapListResponse {
    private long useNo;
    private long boaNo;

    public ScrapListResponse(Scraps entity){
        this.useNo = entity.getUseNo();
        this.boaNo = entity.getBoaNo();
    }
}
