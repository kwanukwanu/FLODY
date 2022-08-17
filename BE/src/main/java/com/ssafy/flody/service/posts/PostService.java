package com.ssafy.flody.service.posts;

import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;
import com.ssafy.flody.dto.request.posts.PostUpdateRequestDto;
import com.ssafy.flody.dto.response.posts.PostDetailResponseDto;

import java.util.List;

public interface PostService {
    public List<PostDetailResponseDto> findPosts(String category);
    public PostDetailResponseDto findPostById(Long posNo);
    public Long addPost(String email, PostCreateRequestDto requestDto);
    public Long modifyPost(PostUpdateRequestDto requestDto);
    public Long removePost(Long posNo);
    public int findPostNum(String email);
}
