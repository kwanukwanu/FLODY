package com.ssafy.flody.dto.request.posts;


//request로 유저 넘버/ 카테고리 넘버를 받을 수 있을지 : 포스팅 시에 카테고리 넘버만 받고 service에서 처리한다고 했던 기억 O

import com.ssafy.flody.domain.posts.Posts;
import com.ssafy.flody.domain.posts.categories.Categories;
import com.ssafy.flody.domain.posts.coverages.Coverages;
import com.ssafy.flody.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    private String title;
    private String content;
    private String hashtag;
    private int likeCnt = 0;
    private int commentCnt = 0;

    @Builder
    public PostCreateRequestDto(String title, String content, String hashtag){
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }
    // DTO to ENTITY
    public Posts toEntity(Users user, Categories category, Coverages coverage){
        return Posts.builder()
                .user(user)
                .category(category)
                .coverage(coverage)
                .title(title)
                .content(content)
                .hashtag(hashtag)
                .likeCnt(likeCnt)
                .commentCnt(commentCnt)
                .build();
    }
}
