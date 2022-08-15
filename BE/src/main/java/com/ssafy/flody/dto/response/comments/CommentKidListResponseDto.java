package com.ssafy.flody.dto.response.comments;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.groups.Groups;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentKidListResponseDto {
    private Long comNo;
    private String writer;
    private Long posNo;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date postDate;

    public CommentKidListResponseDto(Comments entity){
        this.comNo = entity.getComNo();
        this.writer = entity.getUser().getNickname();
        this.posNo = entity.getPost().getPosNo();
        this.content = entity.getContent();
        Calendar cal = Calendar.getInstance();
        cal.setTime(entity.getPostDate());
        cal.add(Calendar.DATE, 1);
        this.postDate = cal.getTime();
    }
}
