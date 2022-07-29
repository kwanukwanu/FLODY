package com.ssafy.flody.dto.request.Boards;

public class CommentCreateRequest {
    private String comment;
    // 가져와서 +1 해주는 (대댓글) 할 때 필요한가 ?
    private Integer kids;
}
