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
public class CommentUpdateRequestDto {
    private Long comNo;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postDate = new Date(System.currentTimeMillis());

//    private Date findToday() {
//        System.out.println(new Date(System.currentTimeMillis()));
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date(System.currentTimeMillis()));
//        cal.add(Calendar.DATE, 1);
//        return cal.getTime();
//    }
}
