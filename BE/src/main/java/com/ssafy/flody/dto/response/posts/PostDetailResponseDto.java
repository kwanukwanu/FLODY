package com.ssafy.flody.dto.response.posts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.posts.Posts;
import lombok.Getter;

import java.util.Calendar;
import java.util.Date;

@Getter
public class PostDetailResponseDto {
    private Long id;
    private String writer;
    private String category;
    private String coverage;
    private String title;
    private String content;
    private String hashtag;
    private int likeCnt;
    private int commentCnt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date postDate;

    public PostDetailResponseDto(Posts entity){
        this.id = entity.getPosNo();
        this.writer = entity.getUser().getNickname();
        this.category = entity.getCategory().getName();
        this.coverage = entity.getCoverage().getName();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.hashtag = entity.getHashtag();
        this.likeCnt = entity.getLikeCnt();
        this.commentCnt = entity.getCommentCnt();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getPostDate());
        cal.add(Calendar.DATE, 1);
        this.postDate = cal.getTime();
    }
}
