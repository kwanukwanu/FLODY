package com.ssafy.flody.service.posts;

import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;

public interface PostService {
    boolean addBoard(PostCreateRequestDto boardCreateRequestDto);
}
