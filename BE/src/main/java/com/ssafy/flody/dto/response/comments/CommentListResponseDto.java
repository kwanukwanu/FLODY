package com.ssafy.flody.dto.response.comments;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.comments.Comments;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class CommentListResponseDto {
    private Long comNo;
    private String writer;
    private Long posNo;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date postDate;
    private int kids;
    private List<CommentKidListResponseDto> kidList;

    public CommentListResponseDto(Comments entity, List<CommentKidListResponseDto> kidList){
        this.comNo = entity.getComNo();
        this.writer = entity.getUser().getNickname();
        this.posNo = entity.getPost().getPosNo();
        this.content = entity.getContent();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getPostDate());
        cal.add(Calendar.DATE, 1);
        this.postDate = cal.getTime();
        this.kids = kidList.size();
        this.kidList = kidList;
    }
}
