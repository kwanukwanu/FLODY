package com.ssafy.flody.dto.request.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String content;
    private String hashtag;

    @Builder
    public PostUpdateRequestDto(
            String title, String content, String hashtag
    ){
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }
}
