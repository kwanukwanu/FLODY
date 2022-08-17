package com.ssafy.flody.dto.response.posts;

import com.ssafy.flody.domain.posts.Posts;
import lombok.Getter;

import java.util.Date;

@Getter
public class PostListResponseDto {
    private String title;
    private Integer likeCnt;
    private Integer commentCnt;
    private Date postDate;

    public PostListResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.likeCnt = entity.getLikeCnt();
        this.commentCnt = entity.getCommentCnt();
        this.postDate = entity.getPostDate();
    }
}
