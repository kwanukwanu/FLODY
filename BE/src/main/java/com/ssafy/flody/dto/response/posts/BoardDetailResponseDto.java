package com.ssafy.flody.dto.response.posts;

import com.ssafy.flody.domain.posts.Posts;
import lombok.Getter;

import java.util.Date;

@Getter
public class BoardDetailResponseDto {
    private String title;
    private String content;
    private String hashtag;
    private Integer likeCnt;
    private Integer commentCnt;
    private Date postDate;

    public BoardDetailResponseDto(Posts entity){
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.hashtag = entity.getHashtag();
        this.likeCnt = entity.getLikeCnt();
        this.commentCnt = entity.getCommentCnt();
        this.postDate = entity.getPostDate();
    }
}
