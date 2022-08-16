package com.ssafy.flody.service.posts.like;

public interface PLikeService {
    public Long addPostLike(String email, Long posNo) throws Exception;
    public Long removePostLike(String email, Long posNo);
}
