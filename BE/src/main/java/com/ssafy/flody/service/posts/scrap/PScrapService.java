package com.ssafy.flody.service.posts.scrap;

public interface PScrapService {
    public Long addPostScrap(String email, Long posNo) throws Exception;
    public Long removePostScrap(String email, Long posNo);
}
