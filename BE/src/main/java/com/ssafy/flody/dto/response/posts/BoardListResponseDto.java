package com.ssafy.flody.dto.response.posts;

import com.ssafy.flody.domain.posts.Posts;
import lombok.Getter;

import java.util.Date;

@Getter
public class BoardListResponseDto {
    private String title;
    private Integer likeCnt;
    private Integer commentCnt;
    private Date postDate;

    public BoardListResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.likeCnt = entity.getLikeCnt();
        this.commentCnt = entity.getCommentCnt();
        this.postDate = entity.getPostDate();
    }
}
