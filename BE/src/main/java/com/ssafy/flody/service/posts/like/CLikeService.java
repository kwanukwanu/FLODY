package com.ssafy.flody.service.posts.like;

public interface CLikeService {
    public Long addCommentLike(String email, Long posNo) throws Exception;
    public Long removeCommentLike(String email, Long posNo);
}
