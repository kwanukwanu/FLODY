package com.ssafy.flody.service.boards;

import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;

public interface BoardsService {
    boolean addBoard(PostCreateRequestDto boardCreateRequestDto);
}
