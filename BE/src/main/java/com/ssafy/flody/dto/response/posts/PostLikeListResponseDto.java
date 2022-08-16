package com.ssafy.flody.dto.response.posts;

import com.ssafy.flody.domain.posts.likes.PLikes;
import lombok.Getter;

@Getter
public class PostLikeListResponseDto {
    Long posNo;
    String title;

    public PostLikeListResponseDto(PLikes entity){
        this.posNo = entity.getPost().getPosNo();
        this.title = entity.getPost().getTitle();
    }
}
