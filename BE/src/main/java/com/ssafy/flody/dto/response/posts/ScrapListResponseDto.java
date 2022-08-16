package com.ssafy.flody.dto.response.posts;

import com.ssafy.flody.domain.posts.likes.PLikes;
import com.ssafy.flody.domain.posts.scraps.Scraps;
import lombok.Getter;

@Getter
public class ScrapListResponseDto {
    Long posNo;
    String title;

    public ScrapListResponseDto(Scraps entity){
        this.posNo = entity.getPost().getPosNo();
        this.title = entity.getPost().getTitle();
    }
}
