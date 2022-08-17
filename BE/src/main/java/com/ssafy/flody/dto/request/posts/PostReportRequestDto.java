package com.ssafy.flody.dto.request.posts;

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.reports.PReports;
import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostReportRequestDto {
    private String content;

    @Builder
    public PostReportRequestDto(String content){
        this.content = content;
    }

    public PReports toEntity(Users user, Posts post, String content){
        return PReports.builder()
                .user(user)
                .post(post)
                .content(content)
                .build();
    }
}
