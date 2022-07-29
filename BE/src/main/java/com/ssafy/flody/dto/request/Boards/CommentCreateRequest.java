package com.ssafy.flody.dto.request.Boards;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentCreateRequest {
    private Long upper;
    private String comment;
    // 가져와서 +1 해주는 (대댓글) 할 때 필요한가 ?
    private Integer kids;

    @Builder
    public CommentCreateRequest(Long upper, String comment, Integer kids){
        this.upper = upper;
        this.comment = comment;
        this.kids = kids;
    }

    //dto to entity
/*    public Comments toEntity(){
        return Comments.builder()
                .upper(upper)
                .comment(comment)
                .kids(kids)
                .build();
    }*/
}
