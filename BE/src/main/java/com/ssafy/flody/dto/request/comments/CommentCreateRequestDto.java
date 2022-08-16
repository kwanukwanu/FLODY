package com.ssafy.flody.dto.request.comments;

import com.ssafy.flody.domain.comments.Comments;
import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Calendar;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CommentCreateRequestDto {
    private Long posNo;
    @Nullable
    private Long upper;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postDate = new Date(System.currentTimeMillis());
    private int kids = 0;

    @Builder
    public CommentCreateRequestDto(Long upper, String content){
        this.upper = upper;
        this.content = content;
    }

    //dto to entity
    public Comments toEntity(Users user, Posts post){
        return Comments.builder()
                .user(user)
                .post(post)
                .upper(upper)
                .content(content)
                .postDate(postDate)
                .kids(kids)
                .build();
    }

//    public Date findToday() {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date(System.currentTimeMillis()));
//        cal.add(Calendar.DATE, 1);
//        return cal.getTime();
//    }
}
