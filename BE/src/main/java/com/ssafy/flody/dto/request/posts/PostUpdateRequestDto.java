package com.ssafy.flody.dto.request.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private Long posNo;
    @Nullable
    private String title;
    @Nullable
    private String content;
    @Nullable
    private String hashtag;

    @Builder
    public PostUpdateRequestDto(String title, String content, String hashtag) {
        if (title != null) this.title = title;
        if (content != null) this.content = content;
        if (hashtag != null) this.hashtag = hashtag;
    }
}
